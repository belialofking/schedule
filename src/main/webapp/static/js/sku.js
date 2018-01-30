/**
 * SKU组合
 * 1、 .F-sku   这个类变化这里的js单击事件类名也要改
 * 2、 .F-title 这个类作用是取到所有标题的值，赋给表格，如有改变JS也应相应改动
 * 3、 .F-item  这个类作用是取类型组数，有多少类型就添加相应的类名：如: F-item1、F-item2、F-item3 ...
 */
$(function(){
    $(".J-sku label").on("change",function(){
        step.Creat_Table();
		if($(this).hasClass("on")){
			$(this).removeClass('on');
		}else{
			$(this).addClass('on');
		}
    });
    var step = {
        //SKU信息组合
        Creat_Table: function () {
            step.hebingFunction();
            var SKUObj = $(".sku-txt");
            //var skuCount = SKUObj.length;//
            var arrayTile = new Array();//标题组数
            var arrayInfor = new Array();//盛放每组选中的CheckBox值的对象
            var arrayColumn = new Array();//指定列，用来合并哪些列
            var bCheck = true;//是否全选
            var columnIndex = 0;
            $.each(SKUObj, function (i, item){
                arrayColumn.push(columnIndex);
                columnIndex++;
                arrayTile.push(SKUObj.eq(i).html().replace("：", ""));
                var itemName = "sku-item" + i;
                //选中的CHeckBox取值
                var order = new Array();
                $("." + itemName + " input[type=checkbox]:checked").each(function (){
                    order.push($(this).val());
                });
                arrayInfor.push(order);
                if (order.join() == ""){
                    bCheck = false;
                }
                //var skuValue = SKUObj.find("li").eq(index).html();
            });
            //开始创建Table表
            if (bCheck == true) {
                var RowsCount = 0;
                $(".sku-table").html("");
                var div = $('<div class="I-table"></div>');
				div.appendTo($(".sku-table"));
				var table = $('<table></table>');
                table.appendTo(div);
                var thead = $("<thead></thead>");
                thead.appendTo(table);
                var trHead = $("<tr></tr>");
                trHead.appendTo(thead);
                //创建表头
                $.each(arrayTile, function (index, item) {
                    var td = $('<th class="text-ctr">' + item + '</th>');
                    td.appendTo(trHead);
                });
                var itemColumHead = $('<th class="text-ctr">数量</th>');
                itemColumHead.appendTo(trHead);
                var tbody = $("<tbody></tbody>");
                tbody.appendTo(table);
                ////生成组合
                var zuheDate = step.doExchange(arrayInfor);
				
                if (zuheDate.length > 0) {
                    //创建行
					console.log(zuheDate);
					
                    $.each(zuheDate, function (index, item) {
                        var td_array = item.split(",");
                        var tr = $('<tr></tr>');
                        tr.appendTo(tbody);
                        $.each(td_array, function (i, values) {
							if(!isNaN(values)){
							  var td = $('<td class="text-ctr">' + values + '<input name="sku[size][]" type="hidden" value="' + values + '"></td>');
							}else{
							  var td = $('<td class="text-ctr">' + values + '<input name="sku[color][]" type="hidden" value="' + values + '"></td>');
							}
							td.appendTo(tr);
                        });
                        var td1 = $('<td ><input name="sku[sum][]" class="sku-text" type="text" value=""></td>');
                        td1.appendTo(tr);
                    });
                }
                //结束创建Table表
                arrayColumn.pop();//删除数组中最后一项
                //合并单元格
                $(table).mergeCell({
                    // 目前只有cols这么一个配置项, 用数组表示列的索引,从0开始
                    cols: arrayColumn
                });
            } else{
                //未全选中,清除表格
                $(".sku-table").html("");
            }
        },//合并行
        hebingFunction: function () {
            $.fn.mergeCell = function (options) {
                return this.each(function () {
                    var cols = options.cols;
                    for (var i = cols.length - 1; cols[i] != undefined; i--) {
                        // fixbug console调试
                        // console.debug(cols[i]);
                        mergeCell($(this), cols[i]);
                    }
                    dispose($(this));
                });
            };
            function mergeCell($table, colIndex) {
                $table.data('col-content', ''); // 存放单元格内容
                $table.data('col-rowspan', 1); // 存放计算的rowspan值 默认为1
                $table.data('col-td', $()); // 存放发现的第一个与前一行比较结果不同td(jQuery封装过的), 默认一个"空"的jquery对象
                $table.data('trNum', $('tbody tr', $table).length); // 要处理表格的总行数, 用于最后一行做特殊处理时进行判断之用
                // 进行"扫面"处理 关键是定位col-td, 和其对应的rowspan
                $('tbody tr', $table).each(function (index) {
                    // td:eq中的colIndex即列索引
                    var $td = $('td:eq(' + colIndex + ')', this);
                    // 取出单元格的当前内容
                    var currentContent = $td.html();
                    // 第一次时走此分支
                    if ($table.data('col-content') == '') {
                        $table.data('col-content', currentContent);
                        $table.data('col-td', $td);
                    } else {
                        // 上一行与当前行内容相同
                        if ($table.data('col-content') == currentContent) {
                            // 上一行与当前行内容相同则col-rowspan累加, 保存新值
                            var rowspan = $table.data('col-rowspan') + 1;
                            $table.data('col-rowspan', rowspan);
                            // 值得注意的是 如果用了$td.remove()就会对其他列的处理造成影响
                            $td.hide();
                            // 最后一行的情况比较特殊一点
                            // 比如最后2行 td中的内容是一样的, 那么到最后一行就应该把此时的col-td里保存的td设置rowspan
                            if (++index == $table.data('trNum'))
                                $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
                        } else { // 上一行与当前行内容不同
                            // col-rowspan默认为1, 如果统计出的col-rowspan没有变化, 不处理
                            if ($table.data('col-rowspan') != 1) {
                                $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
                            }
                            // 保存第一次出现不同内容的td, 和其内容, 重置col-rowspan
                            $table.data('col-td', $td);
                            $table.data('col-content', $td.html());
                            $table.data('col-rowspan', 1);
                        }
                    }
                });
            }
            // 同样是个private函数 清理内存之用
            function dispose($table) {
                $table.removeData();
            }
        },
        //组合数组
        doExchange: function (doubleArrays) {
            var len = doubleArrays.length;
            if (len >= 2) {
                var arr1 = doubleArrays[0];
                var arr2 = doubleArrays[1];
                var len1 = doubleArrays[0].length;
                var len2 = doubleArrays[1].length;
                var newlen = len1 * len2;
                var temp = new Array(newlen);
                var index = 0;
                for (var i = 0; i < len1; i++) {
                    for (var j = 0; j < len2; j++) {
                        temp[index] = arr1[i] + "," + arr2[j];
                        index++;
                    }
                }
                var newArray = new Array(len - 1);
                newArray[0] = temp;
                if (len > 2) {
                    var _count = 1;
                    for (var i = 2; i < len; i++) {
                        newArray[_count] = doubleArrays[i];
                        _count++;
                    }
                }
                //console.log(newArray);
                return step.doExchange(newArray);
            }
            else {
                return doubleArrays[0];
            }
        }
    }
    return step;
})