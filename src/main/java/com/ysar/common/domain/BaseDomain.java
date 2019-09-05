package com.ysar.common.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类<br> 内含主键,创建人,更新人,创建日期,更新日期
 *
 * @author shenwei
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseDomain<T extends Model> extends Model<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5346851389806708599L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.DEFAULT)
    private LocalDateTime createDate;

    /**
     * 更新日期
     */
    @TableField(fill = FieldFill.DEFAULT)
    private LocalDateTime updateDate;

    /**
     * 创建人id
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createUserId;

    /**
     * 最后更新人id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateUserId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
