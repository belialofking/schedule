;(function($) {
	$.aiui = {
		checkbox: function() {
			$(".J_checkbox[type='checkbox']").each(function(){
				var a = $(this).attr("name"),
					v = $(this).attr("value"),
					t = $(this).attr("title");
				if(this.checked){
					$(this).replaceWith('<div class="J_checkbox"><input type="checkbox" name="' + a + '" value="' + v + '" checked="checked"><dl class="on"><span>' + t + '</span><i class="icon ai-check"></i></dl></div>');
				}else{
					$(this).replaceWith('<div class="J_checkbox"><input type="checkbox" name="' + a + '" value="' + v + '"><dl><span>' + t + '</span><i class="icon ai-check"></i></dl></div>');
				}
				
			});
				
		},
		radio: function() {
			$(".J_radio[type='radio']").each(function(){
				var a = $(this).attr("name"),
					v = $(this).attr("value");
				if(this.checked){
					$(this).replaceWith('<div class="J_radio"><input type="radio" name="' + a + '" value="' + v + '" checked="checked"><dl class="on"><i class="icon ai-radio-on"></i><span>' + v + '</span></dl></div>');
				}else{
					$(this).replaceWith('<div class="J_radio"><input type="radio" name="' + a + '" value="' + v + '"><dl><i class="icon ai-radio"></i><span>' + v + '</span></dl></div>');
				}
				
			});
			
		},
		select: function() {
			
		},
		click: function() {
			$(".J_form").on("click",".J_checkbox",function(){
				if($(this).find('dl').hasClass("on")){
					$(this).find('dl').removeClass('on');
					$(this).find("input[type='checkbox']").attr('checked', false);
				}else{
					$(this).find('dl').addClass('on');
					$(this).find("input[type='checkbox']").attr('checked', true);
				}
			});
			$(".J_form").on("click",".J_radio",function(){  
				if(!this.checked){
					$(this).find("dl").addClass('on');
					$(this).find("dl i").addClass('ai-radio-on').removeClass('ai-radio');
					$(this).find("input[type='radio']").attr('checked', true);
					$(this).siblings().find('dl').removeClass('on');
					$(this).siblings().find('dl i').removeClass('ai-radio-on').addClass('ai-radio');
					$(this).siblings().find("input[type='radio']").attr('checked', false);
				}
			});
			$(".J_form").on("click",".J_select",function(){  
				var i = $(this).index('.J_select');
				$(this).find("dl").show();
				$(this).find("dd").click(function(){
					var v = $(this).text();
					var n = $(this).index();
					$(this).addClass('on').siblings().removeClass();
					$(".J_select").eq(i).find('.select-input').val(v);
					$(".J_select").eq(i).find("option").eq(n+1).attr('selected', true).siblings().attr('selected', false);
				});
				$(".J_select").mouseleave(function(){
					$(this).find("dl").hide();
				});
			});
			//开关按钮
			$(".J_no").click(function(){
				var parent = $(this).parents('.btn-no');
				$(this).removeClass('off').addClass('no');
				$('.J_off',parent).removeClass('no').addClass('off');
				$('.J_open',parent).attr('checked', true);
				$('.J_shut',parent).attr('checked', false);
			});
			$(".J_off").click(function(){
				var parent = $(this).parents('.btn-no');
				$(this).removeClass('off').addClass('no');
				$('.J_no',parent).removeClass('no').addClass('off');
				$('.J_shut',parent).attr('checked', true);
				$('.J_open',parent).attr('checked', false);
			});
			// TAB多栏选卡
			var tab = $(".J_tab .tab-nav li");
			tab.click(function(){
				$(this).addClass('on').siblings().removeClass();
				$('.J_tab_con').eq(tab.index(this)).show().siblings().hide();
			});
			//全选 反选
			$(".J_checkAll").click(function(){
				var name = this.id.substring(0,this.id.length-3);
				if(this.checked){
					$("#"+name).find("input[name='"+name+"[]']").each(function(){this.checked=true;});
				}else{
					$("#"+name).find("input[name='"+name+"[]']").each(function(){this.checked=false;});
				}
				checkAll(name);
			});
			$(".J_check").click(function() {
				var name = $(this).parents().parents().parents().attr('id');
				checkAll(name);
			});
			function checkAll(name){
				var list = document.getElementsByClassName("J_checkAll");
				for(var i=0;i<list.length;i++){
				   if(list[i].id == name+"All" || list[i].id == name+"Alb"){
					   list[i].checked=($("#"+name).find("input[name='"+name+"[]']").length == $("#"+name).find("input[name='"+name+ "[]']:checked").length ? true : false);
				   }
				}
			};
				}
			}; 
			
			// 数量加减
			$ (".J_num .jian").click (function (){
				var me = $ (this), txt = me.next (":text");
				var val = parseFloat (txt.val ());
				if (!val) {
					txt.val (1);
				}else if(val < 0){
					var shu = Math.abs(val);
					/* txt.val (-(shu + 1)); */
					txt.val (1);
				}else if(val > 0){
					if(val == 1){
						txt.val (1);  
					}else{
						txt.val (val - 1);			
					}
				}
				var sum = 0;
			});
			$(".J_num .jia").click (function (){
				var me = $ (this), txt = me.prev (":text");
				var val = parseFloat (txt.val ());
				if(val >= 1){
					txt.val (val + 1);   
				}else if(val < 0){
					if(val == -1){
						txt.val ("");  
					}else{
						var shu = Math.abs(val);
						txt.val (-(shu - 1));			
					}
				}else{
					txt.val (1);			
				}
				var sum = 0;
			});
	$(function() {
		$.aiui.checkbox();
		$.aiui.radio();
		$.aiui.select();
		$.aiui.click();
		$("textarea").froalaEditor({
			language: "zh_cn",
		})
	});
})(jQuery);