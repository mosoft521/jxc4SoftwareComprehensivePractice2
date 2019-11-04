$(function() {

    var navJson = [
        {
            "text": "基础信息",
            "children": [
                {
                    "text": "部门",
                    "url": "https://localhost:8080/dept/list"
                },
                {
                    "text": "员工类别",
                    "url": "https://localhost:8080/empType/list"
                },
                {
                    "text": "客户类别",
                    "url": "https://localhost:8080/customerType/list"
                },
                {
                    "text": "仓库",
                    "url": "https://localhost:8080/warehouse"
                }
            ]
        },
        {
            "text": "采购入库",
            "children": [
                {
                    "text": "采购",
                    "url": "https://localhost:8080/purchase"
                },
                {
                    "text": "入库",
                    "url": "https://localhost:8080/stockIn"
                }
            ]
        },
        {
            "text": "销售出库",
            "children": [
                {
                    "text": "销售",
                    "url": "https://localhost:8080/sale"
                },
                {
                    "text": "出库",
                    "url": "https://localhost:8080/stockOut"
                }
            ]
        }
    ];
    // 首页tab显示
    $('#tabs').tabs({
        fit : true,
        border : false,
    });

    // 导航树加载
    $('#nav').tree({
        data: navJson,
        lines : true,
        onClick : function(node) {
            if (node.url) {
                if ($('#tabs').tabs('exists', node.text)) {
                    $('#tabs').tabs('select', node.text);
                } else {
                    $('#tabs').tabs('add', {
                        title : node.text,
                        iconCls : node.iconCls,
                        content : '<iframe scrolling="auto" frameborder="0"  src="'+node.url+'" style="width:100%;height:100%;"></iframe>',
                        closable : true,
                    });
                }
            }
        }
    });

    // 绑定右键菜单
    $('#tabs').tabs({
        'onContextMenu' : function(e, title, index) {
            // 阻止默认
            e.preventDefault();
            // 显示菜单mm
            if (index > 0) {
                $('#mm').menu('show', {
                    left : e.pageX,
                    top : e.pageY
                }).data("tabIndex", index);// 把当前索引放进去
                $('#tabs').tabs('select', index);// 选中当前tab
            }
        }
    });

    // 关闭当前
    $('#mm-tabclose').click(function() {
        $('#tabs').tabs('close', $('#mm').data("tabIndex"));// 关闭当前tab页
    });

    // 全部关闭
    $('#mm-tabcloseall').click(function() {
        // $('#tabs').tabs('tabs') 返回所有panel，本想用这个方法，需要查找相应节点
        $('.tabs-inner span').each(function(i, n) {
            var t = $(n).text();
            if (t !== '首页') {
                $('#tabs').tabs('close', t);
            }
        });
    });

    // 关闭除当前之外的TAB
    $('#mm-tabcloseother').click(function() {
        $('#mm-tabcloseright').click();
        $('#mm-tabcloseleft').click();
    });

    // 关闭当前右侧的TAB
    $('#mm-tabcloseright').click(function() {
        var nextall = $('.tabs-selected').nextAll();
        if (nextall.length == 0) {
            return false;
        }
        nextall.each(function(i, n) {
            var t = $('a:eq(0) span', $(n)).text();
            if (t !== '首页') {
                $('#tabs').tabs('close', t);
            }
        });
    });
    // 关闭当前左侧的TAB
    $('#mm-tabcloseleft').click(function() {
        var prevall = $('.tabs-selected').prevAll();
        if (prevall.length == 0) {
            return false;
        }
        prevall.each(function(i, n) {
            var t = $('a:eq(0) span', $(n)).text();
            if (t !== '首页') {
                $('#tabs').tabs('close', t);
            }
        });
    });
})