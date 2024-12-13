package com.ppxb.latee.admin.auth.model.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Schema(description = "路由信息")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouteResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "父级菜单ID")
    private Long parentId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "类型")
    private Integer type;

    @Schema(description = "路由地址")
    private String path;

    @Schema(description = "组件名称")
    private String name;

    @Schema(description = "组件路径")
    private String component;

    @Schema(description = "重定向地址")
    private String redirect;

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "是否外链")
    private Boolean isExternal;

    @Schema(description = "是否缓存")
    private Boolean isCache;

    @Schema(description = "是否隐藏")
    private Boolean isHidden;

    @Schema(description = "权限标识")
    private String permission;

    @Schema(description = "排序")
    private Integer order;

    @Schema(description = "子路由")
    private List<RouteResp> children;
}
