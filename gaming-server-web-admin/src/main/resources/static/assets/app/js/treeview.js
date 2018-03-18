var TreeView = function () {

    /**
     * 初始化树控件
     * @param id 树控件的元素 ID
     * @param url Ajax 请求地址
     * @param callback 回调函数，用于绑定树节点的点击事件
     */
    var handlerInitTree = function (id, url, callback) {
        $("#" + id).jstree({
            "core": {
                "themes": {
                    "responsive": false
                },
                // so that create works
                "check_callback": true,
                'data': {
                    'url': function (node) {
                        return url;
                    },
                    'data': function (node) {
                        return {'pid': node.id};
                    }
                }
            },
            "types": {
                "default": {
                    "icon": "fa fa-folder m--font-brand"
                },
                "file": {
                    "icon": "fa fa-file  m--font-brand"
                }
            },
            "state": {"key": "demo3"},
            "plugins": ["dnd", "state", "types"]
        });


        $('#' + id).bind("activate_node.jstree", function (obj, e) {
            callback(obj, e);
        });
    };

    return {
        initTree: function (id, url, callback) {
            handlerInitTree(id, url, callback);
        }
    }
}();