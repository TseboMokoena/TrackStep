package tsebomokoena.trackstep

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Maps : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val mGPS = GPSTracker(this)
        val zoom = 16.5F

        if(mGPS.canGetLocation ){
            mGPS.getLocation()
        val coordinate = LatLng(mGPS.latitude, mGPS.longitude)
        mMap.addMarker(MarkerOptions().position(coordinate).title("Current Location"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate,zoom))
        }
    }
}
