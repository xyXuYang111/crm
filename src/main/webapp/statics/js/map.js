// 百度地图API功能
var map = new BMap.Map("map");
map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用
map.enableContinuousZoom(); //启用地图惯性拖拽，默认禁用
map.centerAndZoom(new BMap.Point(116.404, 39.915), 13);

function showInfo(e) {
	$(".latitude").val(e.point.lat);
	$(".longitude").val(e.point.lng);
}
map.centerAndZoom(BMap, 14);
map.enableScrollWheelZoom();
map.enableInertialDragging();

map.enableContinuousZoom();

var size = new BMap.Size(10, 20);
map.addControl(new BMap.CityListControl({
	anchor: BMAP_ANCHOR_TOP_LEFT,
	offset: size,

}));
map.addEventListener("click", showInfo);

function myFun(result) {
	var cityName = result.name;
	map.setCenter(cityName);
}
var myCity = new BMap.LocalCity();
myCity.get(myFun);