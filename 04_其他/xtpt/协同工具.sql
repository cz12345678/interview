CREATE TABLE "t_dv_ywlcb" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_ssmb" varchar(32) COLLATE "default",
"c_lcbh" varchar(300) COLLATE "default",
"c_lcmc" varchar(300) COLLATE "default",
"c_lcms" varchar(300) COLLATE "default",
"dt_cjsj" timestamp(6),
"dt_gxsj" timestamp(6),
"n_sort" int4,
"n_zt" int4,
"c_fsf" varchar(300) COLLATE "default",
"c_jsf" varchar(300) COLLATE "default",
"n_nfjr" int4 DEFAULT 1
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_ywlcb" IS '业务流程表';
COMMENT ON COLUMN "t_dv_ywlcb"."c_bh" IS '唯一标识';
COMMENT ON COLUMN "t_dv_ywlcb"."c_ssmb" IS '所属模板的唯一标识';
COMMENT ON COLUMN "t_dv_ywlcb"."c_lcbh" IS '业务流程编号';
COMMENT ON COLUMN "t_dv_ywlcb"."c_lcmc" IS '业务流程名称';
COMMENT ON COLUMN "t_dv_ywlcb"."c_lcms" IS '业务流程描述';
COMMENT ON COLUMN "t_dv_ywlcb"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_dv_ywlcb"."dt_gxsj" IS '更新时间';
COMMENT ON COLUMN "t_dv_ywlcb"."n_sort" IS '序号';
COMMENT ON COLUMN "t_dv_ywlcb"."n_zt" IS '业务流程状态';
COMMENT ON COLUMN "t_dv_ywlcb"."c_fsf" IS '发送方';
COMMENT ON COLUMN "t_dv_ywlcb"."c_jsf" IS '接收方';
COMMENT ON COLUMN "t_dv_ywlcb"."n_nfjr" IS '能否作为新接入点，1可接入';
ALTER TABLE "t_dv_ywlcb" OWNER TO "postgres";

CREATE TABLE "t_dv_jdgxb" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_lcbh" varchar(300) COLLATE "default",
"c_ssmb" varchar(32) COLLATE "default",
"c_jdbh" varchar(300) COLLATE "default",
"c_jdms" varchar(300) COLLATE "default",
"n_bx" int4,
"n_dt" int4,
"n_gy" int4,
"dt_cjsj" timestamp(6),
"dt_gxsj" timestamp(6),
"c_pid" varchar(300) COLLATE "default",
"n_jdcd" int4,
"c_jdlx" varchar(300) COLLATE "default",
"n_dm" int4,
"c_code" varchar(300) COLLATE "default",
"c_jdsm" varchar(300) COLLATE "default",
"n_sfsjjd" int4,
"n_jd" int4,
"c_parttern" varchar(300) COLLATE "default",
"n_level" int4,
"n_sort" int4,
"n_type" int4,
"n_fx" int4,
"c_version" varchar(300) COLLATE "default",
"c_sjgz" varchar(300) COLLATE "default",
"c_gdbs" varchar(300) COLLATE "default"
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_jdgxb" IS '节点关系';
COMMENT ON COLUMN "t_dv_jdgxb"."c_bh" IS '唯一标识';
COMMENT ON COLUMN "t_dv_jdgxb"."c_lcbh" IS '业务流程编号';
COMMENT ON COLUMN "t_dv_jdgxb"."c_ssmb" IS '所属模板的唯一标识';
COMMENT ON COLUMN "t_dv_jdgxb"."c_jdbh" IS '节点编号（英文标识）';
COMMENT ON COLUMN "t_dv_jdgxb"."c_jdms" IS '节点描述';
COMMENT ON COLUMN "t_dv_jdgxb"."n_bx" IS '节点是否必须';
COMMENT ON COLUMN "t_dv_jdgxb"."n_dt" IS '节点是否可以多条数据';
COMMENT ON COLUMN "t_dv_jdgxb"."n_gy" IS '节点下多条重复数据是否用有共有节点';
COMMENT ON COLUMN "t_dv_jdgxb"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_dv_jdgxb"."dt_gxsj" IS '更新时间';
COMMENT ON COLUMN "t_dv_jdgxb"."c_pid" IS '父节点唯一标识';
COMMENT ON COLUMN "t_dv_jdgxb"."n_jdcd" IS '数据项长度';
COMMENT ON COLUMN "t_dv_jdgxb"."c_jdlx" IS '数据项类型';
COMMENT ON COLUMN "t_dv_jdgxb"."n_dm" IS '数据项是否为单值代码';
COMMENT ON COLUMN "t_dv_jdgxb"."c_code" IS '如果为单值代码，代码code';
COMMENT ON COLUMN "t_dv_jdgxb"."c_jdsm" IS '节点说明';
COMMENT ON COLUMN "t_dv_jdgxb"."n_sfsjjd" IS '是否为数据节点，是节点，还是数据项';
COMMENT ON COLUMN "t_dv_jdgxb"."n_jd" IS '精度';
COMMENT ON COLUMN "t_dv_jdgxb"."c_parttern" IS '正则表达式';
COMMENT ON COLUMN "t_dv_jdgxb"."n_level" IS '分级';
COMMENT ON COLUMN "t_dv_jdgxb"."n_sort" IS '排序';
COMMENT ON COLUMN "t_dv_jdgxb"."n_type" IS '节点的归属类型';
COMMENT ON COLUMN "t_dv_jdgxb"."n_fx" IS '单值代码是否支持复选';
COMMENT ON COLUMN "t_dv_jdgxb"."c_version" IS '版本';
COMMENT ON COLUMN "t_dv_jdgxb"."c_sjgz" IS '数据规则';
COMMENT ON COLUMN "t_dv_jdgxb"."c_gdbs" IS '固定标识';
ALTER TABLE "t_dv_jdgxb" OWNER TO "postgres";

CREATE TABLE "t_dv_mbxxb" (
"c_bh" varchar(32) COLLATE "default" NOT NULL,
"c_mbmc" varchar(300) COLLATE "default",
"dt_cjsj" timestamp(6),
"dt_gxsj" timestamp(6),
"n_xtxx" int4,
"n_zt" int4,
"c_mblx" varchar(300) COLLATE "default"
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_mbxxb" IS '模板信息表';
COMMENT ON COLUMN "t_dv_mbxxb"."c_bh" IS '模板信息唯一标识';
COMMENT ON COLUMN "t_dv_mbxxb"."c_mbmc" IS '模板名称';
COMMENT ON COLUMN "t_dv_mbxxb"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_dv_mbxxb"."dt_gxsj" IS '更新时间';
COMMENT ON COLUMN "t_dv_mbxxb"."n_xtxx" IS '是否包含系统信息';
COMMENT ON COLUMN "t_dv_mbxxb"."n_zt" IS '模板状态';
COMMENT ON COLUMN "t_dv_mbxxb"."c_mblx" IS '模板类型（业务类型）';
ALTER TABLE "t_dv_mbxxb" OWNER TO "postgres";

CREATE TABLE "t_dv_dygxb" (
"c_bh" varchar(32) COLLATE "default" NOT NULL,
"c_path" varchar(300) COLLATE "default",
"c_sjbmc" varchar(300) COLLATE "default",
"c_zdmc" varchar(300) COLLATE "default",
"c_sjlx" varchar(300) COLLATE "default",
"c_zhlx" varchar(300) COLLATE "default",
"c_zhlxz" varchar(300) COLLATE "default",
"c_ssmb" varchar(32) COLLATE "default",
"c_jdbh" varchar(32) COLLATE "default",
"c_lcbh" varchar(300) COLLATE "default",
"c_version" varchar(300) COLLATE "default"
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_dygxb" IS '节点数据对应关系表';
COMMENT ON COLUMN "t_dv_dygxb"."c_bh" IS '唯一标识';
COMMENT ON COLUMN "t_dv_dygxb"."c_path" IS '节点路径';
COMMENT ON COLUMN "t_dv_dygxb"."c_sjbmc" IS '数据表名称';
COMMENT ON COLUMN "t_dv_dygxb"."c_zdmc" IS '数据字段名称';
COMMENT ON COLUMN "t_dv_dygxb"."c_sjlx" IS '数据类型';
COMMENT ON COLUMN "t_dv_dygxb"."c_zhlx" IS '数据转换类型';
COMMENT ON COLUMN "t_dv_dygxb"."c_zhlxz" IS '数据转换类型的值';
COMMENT ON COLUMN "t_dv_dygxb"."c_ssmb" IS '所属模板的唯一标识';
COMMENT ON COLUMN "t_dv_dygxb"."c_jdbh" IS '所属节点唯一标识';
COMMENT ON COLUMN "t_dv_dygxb"."c_lcbh" IS '所属流程编号';
COMMENT ON COLUMN "t_dv_dygxb"."c_version" IS '版本';
ALTER TABLE "t_dv_dygxb" OWNER TO "postgres";

CREATE TABLE "t_dv_bglgxb" (
"c_bh" varchar(32) COLLATE "default" NOT NULL,
"c_sjbmc" varchar(300) COLLATE "default" NOT NULL,
"c_pk" varchar(300) COLLATE "default" NOT NULL,
"c_fk" varchar(300) COLLATE "default",
"c_pname" varchar(300) COLLATE "default",
"c_path" varchar(300) COLLATE "default" NOT NULL,
"c_zhlx" varchar(300) COLLATE "default",
"c_zhlxz" varchar(300) COLLATE "default",
"c_lcbh" varchar(300) COLLATE "default",
"c_glzd" varchar(300) COLLATE "default",
"c_ssmb" varchar(32) COLLATE "default" NOT NULL,
"n_sort" int4,
"c_path_cn" varchar(300) COLLATE "default",
"c_sjbmc_cn" varchar(300) COLLATE "default"
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_bglgxb" IS '表之间关联关系表';
COMMENT ON COLUMN "t_dv_bglgxb"."c_bh" IS '唯一标识';
COMMENT ON COLUMN "t_dv_bglgxb"."c_sjbmc" IS '数据表名称';
COMMENT ON COLUMN "t_dv_bglgxb"."c_pk" IS '主键';
COMMENT ON COLUMN "t_dv_bglgxb"."c_fk" IS '外键';
COMMENT ON COLUMN "t_dv_bglgxb"."c_pname" IS '父表名称';
COMMENT ON COLUMN "t_dv_bglgxb"."c_path" IS '节点路径';
COMMENT ON COLUMN "t_dv_bglgxb"."c_zhlx" IS '数据转换类型';
COMMENT ON COLUMN "t_dv_bglgxb"."c_zhlxz" IS '数据转换类型的值';
COMMENT ON COLUMN "t_dv_bglgxb"."c_lcbh" IS '所属流程编号';
COMMENT ON COLUMN "t_dv_bglgxb"."c_glzd" IS '关联父表字段';
COMMENT ON COLUMN "t_dv_bglgxb"."c_ssmb" IS '所属模板的唯一标识';
COMMENT ON COLUMN "t_dv_bglgxb"."n_sort" IS '序号';
COMMENT ON COLUMN "t_dv_bglgxb"."c_path_cn" IS '中文路径';
COMMENT ON COLUMN "t_dv_bglgxb"."c_sjbmc_cn" IS '表中文名';
ALTER TABLE "t_dv_bglgxb" OWNER TO "postgres";

CREATE TABLE "t_dv_wsjzlb" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_ssmb" char(32) COLLATE "default",
"c_lcbh" varchar(300) COLLATE "default",
"c_wsjzmc" varchar(300) COLLATE "default",
"n_lx" int4,
"n_jghsj" int4,
"dt_cjsj" timestamp(6),
"dt_gxsj" timestamp(6),
"n_sort" int4,
"n_bx" int4
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_wsjzlb" IS '文书卷宗列表';
COMMENT ON COLUMN "t_dv_wsjzlb"."c_bh" IS '主键编号';
COMMENT ON COLUMN "t_dv_wsjzlb"."c_ssmb" IS '所属模版';
COMMENT ON COLUMN "t_dv_wsjzlb"."c_lcbh" IS '流程编号';
COMMENT ON COLUMN "t_dv_wsjzlb"."c_wsjzmc" IS '文书或者卷宗名称';
COMMENT ON COLUMN "t_dv_wsjzlb"."n_lx" IS '类型';
COMMENT ON COLUMN "t_dv_wsjzlb"."n_jghsj" IS '是否包含结构化数据';
COMMENT ON COLUMN "t_dv_wsjzlb"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_dv_wsjzlb"."dt_gxsj" IS '更新时间';
COMMENT ON COLUMN "t_dv_wsjzlb"."n_sort" IS '排序';
ALTER TABLE "t_dv_wsjzlb" OWNER TO "postgres";

CREATE TABLE "t_dv_wsjzjghsj" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_sswsjz" char(32) COLLATE "default",
"c_sjxxx" jsonb,
"dt_cjsj" timestamp(6),
"dt_gxsj" timestamp(6),
"n_sort" int4,
"c_ssmb" char(32) COLLATE "default"
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_wsjzjghsj" IS '文书卷宗结构化数据项';
COMMENT ON COLUMN "t_dv_wsjzjghsj"."c_bh" IS '主键编号';
COMMENT ON COLUMN "t_dv_wsjzjghsj"."c_sswsjz" IS '所属文书卷宗编号';
COMMENT ON COLUMN "t_dv_wsjzjghsj"."c_sjxxx" IS '数据项信息（JSON）';
COMMENT ON COLUMN "t_dv_wsjzjghsj"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_dv_wsjzjghsj"."dt_gxsj" IS '更新时间';
COMMENT ON COLUMN "t_dv_wsjzjghsj"."n_sort" IS '排序';
COMMENT ON COLUMN "t_dv_wsjzjghsj"."c_ssmb" IS '所属模板编号';
ALTER TABLE "t_dv_wsjzjghsj" OWNER TO "postgres";

CREATE TABLE "t_dv_jzml" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_ssmb" varchar(300) COLLATE "default",
"c_jzmc" varchar(300) COLLATE "default",
"c_jzml" varchar(300) COLLATE "default",
"n_sort" int4,
"dt_cjsj" timestamp(6),
"dt_gxsj" timestamp(6),
"c_mllxdm" varchar(300) COLLATE "default"
)
WITHOUT OIDS;
COMMENT ON TABLE "t_dv_jzml" IS '卷宗目录表';
COMMENT ON COLUMN "t_dv_jzml"."c_bh" IS '主键编号';
COMMENT ON COLUMN "t_dv_jzml"."c_ssmb" IS '所属模版';
COMMENT ON COLUMN "t_dv_jzml"."c_jzmc" IS '卷宗名称';
COMMENT ON COLUMN "t_dv_jzml"."c_jzml" IS '卷宗目录';
COMMENT ON COLUMN "t_dv_jzml"."n_sort" IS '排序';
COMMENT ON COLUMN "t_dv_jzml"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_dv_jzml"."dt_gxsj" IS '更新时间';
ALTER TABLE "t_dv_jzml" OWNER TO "postgres";

CREATE TABLE "t_dv_dwxx" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_lxmc" varchar(300) COLLATE "default",
"c_dwmc" varchar(300) COLLATE "default",
"c_ssmb" varchar(300) COLLATE "default",
"dt_cjsj" timestamp(6),
"dt_gxsj" timestamp(6),
CONSTRAINT "t_dv_dwxx_pkey" PRIMARY KEY ("c_bh") 
)
WITHOUT OIDS;
ALTER TABLE "t_dv_dwxx" OWNER TO "postgres";

CREATE TABLE "t_xt_pz" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_mc" varchar(300) COLLATE "default",
"c_key" varchar(600) COLLATE "default",
"c_value" varchar(900) COLLATE "default",
"c_bh_fl" char(32) COLLATE "default",
"c_sx" varchar(300) COLLATE "default",
"c_sfzm" varchar(300) COLLATE "default",
"c_bz" varchar(300) COLLATE "default",
"dt_cjsj" timestamp(6),
"c_pzlx" varchar(300) COLLATE "default",
"dt_zhxgsj" timestamp(6),
CONSTRAINT "t_xt_pz_pkey" PRIMARY KEY ("c_bh") 
)
WITHOUT OIDS;
CREATE INDEX "f_c_bh_fl" ON "t_xt_pz" USING btree ("c_bh_fl" "pg_catalog"."bpchar_ops" ASC NULLS LAST);
COMMENT ON TABLE "t_xt_pz" IS '协同平台配置数据表';
COMMENT ON COLUMN "t_xt_pz"."c_bh" IS '主键';
COMMENT ON COLUMN "t_xt_pz"."c_mc" IS '配置项名称';
COMMENT ON COLUMN "t_xt_pz"."c_key" IS '配置项key';
COMMENT ON COLUMN "t_xt_pz"."c_value" IS '配置项值';
COMMENT ON COLUMN "t_xt_pz"."c_bh_fl" IS '模块分类编号';
COMMENT ON COLUMN "t_xt_pz"."c_sx" IS '组内顺序';
COMMENT ON COLUMN "t_xt_pz"."c_sfzm" IS '是否转码';
COMMENT ON COLUMN "t_xt_pz"."c_bz" IS '备注';
COMMENT ON COLUMN "t_xt_pz"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_xt_pz"."c_pzlx" IS '配置类型（普通0、特殊1）';
COMMENT ON COLUMN "t_xt_pz"."dt_zhxgsj" IS '最后修改时间';
ALTER TABLE "t_xt_pz" OWNER TO "postgres";

CREATE TABLE "t_xt_pzmk" (
"c_bh" char(32) COLLATE "default" NOT NULL,
"c_mc" varchar(300) COLLATE "default" NOT NULL,
"c_bh_ffl" char(32) COLLATE "default",
"dt_cjsj" timestamp(6),
"dt_zhxgsj" timestamp(6),
CONSTRAINT "t_xt_pzmk_pkey" PRIMARY KEY ("c_bh") 
)
WITHOUT OIDS;
COMMENT ON TABLE "t_xt_pzmk" IS '配置模块分类';
COMMENT ON COLUMN "t_xt_pzmk"."c_bh" IS '主键';
COMMENT ON COLUMN "t_xt_pzmk"."c_mc" IS '模块分类名称';
COMMENT ON COLUMN "t_xt_pzmk"."c_bh_ffl" IS '父级模块分类编号';
COMMENT ON COLUMN "t_xt_pzmk"."dt_cjsj" IS '创建时间';
COMMENT ON COLUMN "t_xt_pzmk"."dt_zhxgsj" IS '最后修改时间';
ALTER TABLE "t_xt_pzmk" OWNER TO "postgres";


ALTER TABLE "t_dv_ywlcb" ADD CONSTRAINT "idx_md" FOREIGN KEY ("c_ssmb") REFERENCES "t_dv_mbxxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_md" ON "t_dv_ywlcb" IS '管理模板信息表';
ALTER TABLE "t_dv_jdgxb" ADD CONSTRAINT "idx_md" FOREIGN KEY ("c_ssmb") REFERENCES "t_dv_mbxxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_md" ON "t_dv_jdgxb" IS '所属模板';
ALTER TABLE "t_dv_jdgxb" ADD CONSTRAINT "idx_lcbh" FOREIGN KEY ("c_lcbh") REFERENCES "t_dv_ywlcb" ("c_lcbh");
ALTER TABLE "t_dv_dygxb" ADD CONSTRAINT "idx_mb" FOREIGN KEY ("c_ssmb") REFERENCES "t_dv_mbxxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_mb" ON "t_dv_dygxb" IS '所属模板';
ALTER TABLE "t_dv_dygxb" ADD CONSTRAINT "idx_lc" FOREIGN KEY ("c_lcbh") REFERENCES "t_dv_ywlcb" ("c_lcbh");
COMMENT ON CONSTRAINT "idx_lc" ON "t_dv_dygxb" IS '流程编号';
ALTER TABLE "t_dv_dygxb" ADD CONSTRAINT "idx_jdbh" FOREIGN KEY ("c_jdbh") REFERENCES "t_dv_jdgxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_jdbh" ON "t_dv_dygxb" IS '节点编号';
ALTER TABLE "t_dv_bglgxb" ADD CONSTRAINT "idx_mb" FOREIGN KEY ("c_ssmb") REFERENCES "t_dv_mbxxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_mb" ON "t_dv_bglgxb" IS '模板';
ALTER TABLE "t_dv_wsjzlb" ADD CONSTRAINT "idx_mb" FOREIGN KEY ("c_ssmb") REFERENCES "t_dv_mbxxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_mb" ON "t_dv_wsjzlb" IS '模板';
ALTER TABLE "t_dv_wsjzlb" ADD CONSTRAINT "idx_lcbh" FOREIGN KEY ("c_lcbh") REFERENCES "t_dv_ywlcb" ("c_lcbh");
COMMENT ON CONSTRAINT "idx_lcbh" ON "t_dv_wsjzlb" IS '流程';
ALTER TABLE "t_dv_wsjzjghsj" ADD CONSTRAINT "idx_mb" FOREIGN KEY ("c_ssmb") REFERENCES "t_dv_mbxxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_mb" ON "t_dv_wsjzjghsj" IS '模板';
ALTER TABLE "t_dv_wsjzjghsj" ADD CONSTRAINT "idx_jz" FOREIGN KEY ("c_sswsjz") REFERENCES "t_dv_wsjzlb" ("c_bh");
COMMENT ON CONSTRAINT "idx_jz" ON "t_dv_wsjzjghsj" IS '卷宗';
ALTER TABLE "t_dv_jzml" ADD CONSTRAINT "idx_mb" FOREIGN KEY ("c_ssmb") REFERENCES "t_dv_mbxxb" ("c_bh");
COMMENT ON CONSTRAINT "idx_mb" ON "t_dv_jzml" IS '模板';

