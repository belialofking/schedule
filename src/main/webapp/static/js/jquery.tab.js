;(function($) {
	$.fn.tx = function(option){
		this.css({ "opacity": "0", "margin-top": "30px" }).delay(100).animate({ opacity: '1', marginTop: "0" }, 300);        
		return this;
	}
	$.tab = {
		tab: function() {
	
			function t(t) {
				var e = 0;
				return $(t).each(function() {
					e += $(this).outerWidth(!0)
				}), e
			}
			function e(e) {
				var a = t($(e).prevAll()),
					i = t($(e).nextAll()),
					n = t($(".tab").children().not(".J_Tabs")),
					s = $(".tab").outerWidth(!0) - n,
					r = 0;
				if ($(".page-con").outerWidth() < s) r = 0;
				else if (i <= s - $(e).outerWidth(!0) - $(e).next().outerWidth(!0)) {
					if (s - $(e).next().outerWidth(!0) > i) {
						r = a;
						for (var o = e; r - $(o).outerWidth() > $(".page-con").outerWidth() - s;) r -= $(o).prev().outerWidth(), o = $(o).prev()
					}
				} else a > s - $(e).outerWidth(!0) - $(e).prev().outerWidth(!0) && (r = a - $(e).prev().outerWidth(!0));
				$(".page-con").animate({
					marginLeft: 0 - r + "px"
				}, "fast")
			}
			
			
			function left() {
				var e = Math.abs(parseInt($(".page-con").css("margin-left"))),
					a = t($(".tab").children().not(".J_Tabs")),
					i = $(".tab").outerWidth(!0) - a,
					n = 0;
				if ($(".page-con").width() < i) return !1;
				for (var s = $(".J_Tab:first"), r = 0; r + $(s).outerWidth(!0) <= e;) r += $(s).outerWidth(!0), s = $(s).next();
				if (r = 0, t($(s).prevAll()) > i) {
					for (; r + $(s).outerWidth(!0) < i && s.length > 0;) r += $(s).outerWidth(!0), s = $(s).prev();
					n = t($(s).prevAll())
				}
				$(".page-con").animate({
					marginLeft: 0 - n + "px"
				}, "fast")
			}
			function right() {
				var e = Math.abs(parseInt($(".page-con").css("margin-left"))),
					a = t($(".tab").children().not(".J_Tabs")),
					i = $(".tab").outerWidth(!0) - a,
					n = 0;
				if ($(".page-con").width() < i) return !1;
				for (var s = $(".J_Tab:first"), r = 0; r + $(s).outerWidth(!0) <= e;) r += $(s).outerWidth(!0), s = $(s).next();
				for (r = 0; r + $(s).outerWidth(!0) < i && s.length > 0;) r += $(s).outerWidth(!0), s = $(s).next();
				n = t($(s).prevAll()), n > 0 && $(".page-con").animate({
					marginLeft: 0 - n + "px"
				}, "fast")
			}
			
			function n() {
				var t = $(this).data("url"),
					a = $(this).data("index"),
					i = $.trim($(this).text()),
					n = !0;
				$(this).addClass("no"), $(".J_Item").each(function(t) {
					return $(this).data("index") == a ?  void 0: $(this).removeClass("no");
				});
				if (void 0 == t || 0 == $.trim(t).length) return !1;
				if ($(".J_Tab").each(function() {
					return $(this).data("url") == t ? ($(this).hasClass("no") || ($(this).addClass("no").siblings(".J_Tab").removeClass("no"), e(this), $(".J_main .J_iframe").each(function() {
						return $(this).attr("src") == t ? ($(this).show().tx().siblings(".J_iframe").hide(), !1) : void 0
					})), n = !1, !1) : void 0
				}), n) {
					var s = '<a href="javascript:;" class="no J_Tab" data-url="' + t + '" data-id="' + a + '">' + i + ' <i class="icon ai-x"></i></a>';
					$(".J_Tab").removeClass("no");
					var r = '<iframe class="J_iframe" src="' + t + '" data-url="' + t + '"></iframe>';
					$(".J_main").find("iframe.J_iframe").hide().parents(".J_main").append(r).tx();
					$(".J_Tabs .page-con").append(s), e($(".J_Tab.no"))
				}
				return !1
			}

			function opt() {
				if (!$(this).hasClass("no")) {
					var t = $(this).data("url"),
					    i = $(this).data("id"),
					    m = $('.J_nav .J_Item').eq(i).parents().parents().parents("li").data("id");
					$('.J_nav li[data-id="' + m + '"]').slideDown().siblings().slideUp(),
					$('.J_menu[data-id="' + m + '"]').parents("li").addClass("no").siblings("li").removeClass("no"),
					$(".J_main .J_iframe").each(function() {
						return $(this).attr("src") == t ? ($(this).show().tx().siblings(".J_iframe").hide(), !1) : void 0
					}),
					$(this).addClass("no").siblings(".J_Tab").removeClass("no"),
					$('.J_Item[data-index="' + i + '"]').addClass("no"), $(".J_Item").each(function(t) {
						return $(this).data("index") == i ?  void 0: $(this).removeClass("no");
					}),e(this)
				}
			}
			function fresh(t) {
				var t = $('.J_iframe[data-url="' + t + '"]'),
					e = t.attr("src");
				t.attr("src", e).tx()
			}
			
			function refresh() {
				var i = $('.J_Tabs .no').data("id"),
					t = $('.J_iframe[data-id="' + i + '"]'),
					e = t.attr("name");
				frames[e].location.reload();
			}
			
			function o() {
				var i = $(this).data("id");
				$(this).parents(".menu-con li").addClass("no").siblings().removeClass();
				$('.J_nav li[data-id="' + i + '"]').slideDown().siblings().slideUp();
				return !1
			}

			function nav(e) {
				var x = e.clientX,
					y = e.clientY;
				e.preventDefault();
				$(".J_click").data('url',$(this).data("url"));
				$(".J_click").data('wd',$(this).width());
				$(".J_click").css({"top":y+'px',"left":x+'px'}).slideDown();
				$(document).click(function(){$('.J_click').slideUp()});
			}
			
			function m(e) {
				var v = $(e.target).data('event'),
					url = $(this).data('url'),
					w = $(this).data('wd');
				switch(v){
					case 'fresh':
						fresh(url);
						break;
					case 'other':
						shut_other(url);
						break;
					case 'all':
						shut_all();
						break;
					default:
				}
			}
			
			function shut() {
				var url = $(this).parents(".J_Tab").data("url"),
					wd = $(this).parents(".J_Tab").width(),
					id = $('.J_Tab[data-url="' + url + '"]');
				if (id.hasClass("no")) {
					if (id.next(".J_Tab").length) {
						var i = id.next(".J_Tab:eq(0)").data("url");
						id.next(".J_Tab:eq(0)").addClass("no"), $(".J_main .J_iframe").each(function() {
							return $(this).data("url") == i ? ($(this).show().tx().siblings(".J_iframe").hide(), !1) : void 0
						});
						var n = parseInt($(".page-con").css("margin-left"));
						0 > n && $(".page-con").animate({
							marginLeft: n + wd + "px"
						}, "fast"), id.remove(), $(".J_main .J_iframe").each(function() {
							return $(this).data("url") == url ? ($(this).remove(), !1) : void 0
						})
					}
					if (id.prev(".J_Tab").length) {
						/* console.log(2); */
						var i = id.prev(".J_Tab:last").data("url");
						id.prev(".J_Tab:last").addClass("no"), $(".J_main .J_iframe").each(function() {
							return $(this).data("url") == i ? ($(this).show().tx().siblings(".J_iframe").hide(), !1) : void 0
						}), id.remove(), $(".J_main .J_iframe").each(function() {
							return $(this).data("url") == url ? ($(this).remove(), !1) : void 0
						})
					}
				} else id.remove(), $(".J_main .J_iframe").each(function() {
					return $(this).data("url") == url ? ($(this).remove(), !1) : void 0
				}), e($(".J_Tab.no"));
				return !1
			}
			
			function shut_all() {
				$(".page-con").children("[data-url]").not(":first").each(function() {
					$('.J_iframe[data-url="' + $(this).data("url") + '"]').remove(), $(this).remove()
				}),
				$(".page-con").children("[data-url]:first").each(function() {
					$('.J_iframe[data-url="' + $(this).data("url") + '"]').show().tx(), $(this).addClass("no")
				}), $(".page-con").css("margin-left", "0")
			}
						
			function shut_other(url) {
				$(".page-con").children("[data-url]").not(":first").not('[data-url="' + url + '"]').each(function() {
					$('.J_iframe[data-url="' + $(this).data("url") + '"]').remove(), $(this).remove()
				}),
				$('.J_Tab[data-url="' + url + '"]').addClass("no"), 
				$('.J_main .J_iframe[data-url="' + url + '"]').show().tx(),
				$('.J_Item[data-url="' + url + '"]').addClass("no"), $(".J_Item").each(function(t) {
					return $(this).data("url") == url ?  void 0: $(this).removeClass("no");
				})
				$(".page-con").css("margin-left", "0")
			}
						
			function fold() {
				$(this).find(".more").toggleClass("no");
				$(this).find("dd").toggle('fast');
			}
			
			$(".J_Item").each(function(t) {
				$(this).attr("data-index", t)
			}),
			$(".J_fold").on("click", fold),
			$(".J_click").on("click", m),
			$(".J_Tabs").on("contextmenu", ".J_Tab", nav),
			$(".J_menu").on("click", o),
			$(".J_Item").on("click", n), 
			$(".J_Tabs").on("click", ".J_Tab i", shut),            //单击关闭  【标签】
			$(".J_Tabs").on("click", ".J_Tab", opt),              //单击切换  【标签】
			$(".J_Tabs").on("dblclick", ".J_Tab", refresh),           //双击刷新
			$(".J_Left").on("click", left),                        //向右移动
			$(".J_Right").on("click", right);                       //向右移动
		}
	}; 
	$(function() {
		$.tab.tab();
	});
})(jQuery);