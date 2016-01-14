"use strict";

var openApp = function (packages,success, fail) {
	 cordova.exec(success, fail, "OpenApp", null, [packages]);
};

module.exports = openApp;
