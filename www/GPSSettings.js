var exec = require('cordova/exec');
function GPSSettings() { 
    console.log("GPSSettings.js: is created");
}

GPSSettings.prototype.goToGPSsettings = function(aString){
        console.log("GPSSettings.js: goToGPSsettings"); 
        exec(function(result){/*alert("OK" + reply);*/}, 
                function(result){/*alert("Error" + reply);*/} ,
                "GPSSettings",
                aString,
                []
            );
} 
var gpsSettings = new GPSSettings(); 
module.exports = gpsSettings;