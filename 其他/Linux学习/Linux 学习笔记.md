###Linux 学习笔记

####1. Linux 使用 yum 安装软件

```tex
已加载插件：fastestmirror
Loading mirror speeds from cached hostfile
 * base: mirrors.163.com
 * extras: mirrors.163.com
 * updates: mirrors.163.com
没有可用软件包 ifconfig。
错误：无须任何处理
```

```tex
	当在Linux系统中使用yum安装软件时提示 “没有可用软件包”时，代表在linux系统yum源中已经没有对应的安装包了，这时，我们需要安装EPEL。

	EPEL（Extra Packages for Enterprise Linux），企业版Linux额外包，RHEL分布非标准包的社区类库。安装如下：

	yum没有找到对应依赖包，更新epel第三方软件库，运行命令：

	yum install -y epel-release,更新完epel第三方软件库后，再次尝试使用yum命令安装对应的软件包。
```

#### 2. 验证 Linux 网卡是否启用

```tex
	1）能 ping （ping www.baidu.com）通的话，说明网卡有启用，并能获取IP地址来上网。（如果不能可以通过vi /etc/sysconfig/network-scripts/ifcfg-enp0s3 ，把ONBOOT改为yes。BOOTPROTO改为dhcp，或者改为手动获取IP地址，详见在centos7网络配置） 注：修改完后需要重启网卡（命令：service network restart）

　　 2）能通ip addr 查到获取的IP地址，证明网卡是启用。如果获取不了请修改网络配置文件。注：修改完后需要重启网卡（命令：service network restart）

　　 3）通过cat /etc/sysconfig/network-scripts/ifcfg-enp0s3 查看网卡是否启用，如果没有使用vi /etc/sysconfig/network-scripts/ifcfg-enp0s3 修改网络配置文件。
```

#### 3. centos 7 使用ifconfig

```tex
1、保证网卡启用；
2、使用yum provides ifconfig 来查看那个包提高ifconfig，并安装；
3、然后执行 yum install net-tools；
4、输入 ifconfig 测试
```

#### 4. centos 7 防火墙

```tex
查看防火墙状态
	systemctl status firewalld.service
	firewall-cmd --state（推荐使用）
	
停止firewall
	systemctl stop firewalld.service
	
开启firewall
	systemctl start firewalld.service

禁止firewall开机启动
	systemctl disable firewalld.service 
```

