function write(content, tag) {
    document.write("<" + tag + ">" + content + "</" + tag + ">");
}
function hr() {
    document.write("<hr>");
}
function writeColor(content, tag, color) {
    document.write("<" + tag + " style='color:" + color + "'>" +
        content + "</" + tag + ">");
}
function writeNewLine(content) {
    document.write(content + "<br>");
}
var sum = function(x, y) {
	if (x == undefined) {
		x = 10;
	}
	if (y == undefined) {
		y = 20;
	}
	//alert("테스트입이당!!" + (x + y));
	return x + y;
}

export { hr, writeColor, sum };