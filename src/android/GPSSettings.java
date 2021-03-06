import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GPSSettings extends CordovaPlugin {
	public static final String TAG = "GPS Settings";
	/**
	* Constructor.
	*/
	public GPSSettings() {}
	/**
	* Sets the context of the Command. This can then be used to do things like
	* get file paths associated with the Activity.
	*
	* @param cordova The context of the main Activity.
	* @param webView The CordovaWebView Cordova is running in.
	*/
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		Log.v(TAG,"Init GPSSettings");
	}

	public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	final int duration = Toast.LENGTH_SHORT;
	// Shows a toast
		Log.v(TAG,"GPSSettings received:"+ action);
		cordova.getActivity().runOnUiThread(new Runnable() {
			public void run() {
				Toast toast = Toast.makeText(cordova.getActivity().getApplicationContext(), action, duration);
				toast.show();
				//Show GPS setteings page				
				Context context = cordova.getActivity().getApplicationContext();
			    
		    	Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			    context.startActivity(intent);			    
				
				//startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
			}
		});
		return true;
	}
}