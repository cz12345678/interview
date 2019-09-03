package com.my.logback;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;


import ch.qos.logback.core.PropertyDefinerBase;

/**
 * @describe: 获取服务器ID
 * @author:  chenzhen-1
 * @date: 2019-8-3-下午1:45:05
 */
public class LogbackIpGetProperty extends PropertyDefinerBase  {
	
    /**默认值*/
    private final static String DEFAULT_VALUE = "ip";
    
    private final static String C_SEP_UNDERLINE = "_";

	@Override
    public String getPropertyValue() {
        Enumeration<NetworkInterface> netInterfaces = null;
        List<String> ipList = new ArrayList<String>();
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress inet = ips.nextElement();
                    if (inet instanceof Inet4Address && (!inet.isLoopbackAddress())) {
                        ipList.add(inet.getHostAddress());
                    }
                }
            }
            if (isEmpty(ipList)) {
                InetAddress addr = InetAddress.getLocalHost();
                ipList.add(addr.getHostAddress());
            }
            return join(ipList.toArray(), C_SEP_UNDERLINE);
        } catch (Exception e) {
            return DEFAULT_VALUE;
        }

    }
	
    private boolean isEmpty(Collection<?> coll) {
        return (coll == null || coll.isEmpty());
    }
    
    
    private String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        return join(array, separator, 0, array.length);
    }
    
    
    public static final String EMPTY = "";
    
    private String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = EMPTY;
        }

        // endIndex - startIndex > 0:   Len = NofStrings *(len(firstString) + len(separator))
        //           (Assuming that all Strings are roughly equally long)
        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return EMPTY;
        }


        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

}
