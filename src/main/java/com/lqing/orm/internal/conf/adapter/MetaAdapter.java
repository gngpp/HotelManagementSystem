package com.lqing.orm.internal.conf.adapter;

import com.lqing.orm.internal.conf.meta.ColumnMeta;

import java.util.List;

public class MetaAdapter implements IMetaAdapter {
    @Override
    public EntityInfo transform(List<ColumnMeta> colMetas) {
        EntityInfo col = new EntityInfo();
        col.columns = new String[colMetas.size() - 1];
        /*
         * 所有字段名的格式都必须是:
         *      TBL_NAME.COL_NAME 也就是 [表名].[字段名]
         *      这样做是为了在多表操作中区分字段.
         */
        int i = 0;
        for (ColumnMeta colMeta : colMetas) {
            if(!colMeta.IS_PRIMARY_KEY){
                col.columns[i++] = colMeta.TBL_NAME + '.' + colMeta.COLUMN_NAME;
            }else {
                col.pk = colMeta.TBL_NAME + '.' + colMeta.COLUMN_NAME;
            }
            col.tbl_name = colMeta.TBL_NAME;
        }
        return col;
    }
}
