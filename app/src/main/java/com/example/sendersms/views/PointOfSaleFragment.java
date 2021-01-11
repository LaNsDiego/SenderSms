package com.example.sendersms.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendersms.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.transition.MaterialContainerTransform;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PointOfSaleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PointOfSaleFragment extends Fragment implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnCameraIdleListener{

    private static final String TAG = "REGISTRO_UBICACION";
    //    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = ;
    private final LatLng mDefaultLocation = new LatLng(-33.8523341, 151.2106085);
    private GoogleMap map;
    private Marker marker;

    private GestureDetectorCompat mDetector;
    //ATRIBUTOS MAPA MI UBICACION
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final int DEFAULT_ZOOM = 15;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean mLocationPermissionGranted;
    // The geographical location where the device is currently located. That is, the last-known
    // location retrieved by the Fused Location Provider.
    private Location mLastKnownLocation;

    // Keys for storing activity state.
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";
    double latitud, longitud;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PointOfSaleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PointOfSaleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PointOfSaleFragment newInstance(String param1, String param2) {
        PointOfSaleFragment fragment = new PointOfSaleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    BottomSheetDialog bsdInfoPoinOfSale;
    BottomSheetBehavior bshInfoPointOfSale;
    TextView txvEstado;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View inflate = inflater.inflate(R.layout.fragment_point_of_sale, container, false);
        txvEstado = inflate.findViewById(R.id.estado);
        View viewBottmSheet = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_post_of_sale,null,false);
        bsdInfoPoinOfSale = new BottomSheetDialog(getContext());
        bsdInfoPoinOfSale.setContentView(viewBottmSheet);
        bsdInfoPoinOfSale.setDismissWithAnimation(true);
        bsdInfoPoinOfSale.setTitle("Titulo grande");
        bshInfoPointOfSale = BottomSheetBehavior.from((View)viewBottmSheet.getParent());
//        bsdInfoPoinOfSale.show();

        bshInfoPointOfSale.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        txvEstado.setText("STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        txvEstado.setText("STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        txvEstado.setText("STATE_HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        txvEstado.setText("STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        txvEstado.setText("STATE_HALF_EXPANDED");
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

//
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());

        getDeviceLocation();
        return inflate;
    }


    /**
     * Saves the state of the map when the activity is paused.
     */
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        if (map != null) {
//            outState.putParcelable(KEY_CAMERA_POSITION, map.getCameraPosition());
//            outState.putParcelable(KEY_LOCATION, mLastKnownLocation);
//            super.onSaveInstanceState(outState);
//        }
//    }


    //2. mostrar mapa y mueve el mapa hacia la ubicacion del dispositivo
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if (marker != null) {

        }
        /*map.setOnCameraIdleListener(this);*/
        marker = map.addMarker(new MarkerOptions().position(mDefaultLocation).title("Ubicación por defecto").draggable(true));
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String estado = "default";
                switch (bshInfoPointOfSale.getState()){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        estado = "STATE_EXPANDED";
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        estado = "STATE_EXPANDED";
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        estado = "STATE_EXPANDED";
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        estado = "STATE_EXPANDED";
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        estado = "STATE_EXPANDED";
                        break;

                    default:
                        break;
                }
                bshInfoPointOfSale.setState(BottomSheetBehavior.STATE_COLLAPSED);
                Toast.makeText(getContext(), estado, Toast.LENGTH_SHORT).show();
                bsdInfoPoinOfSale.show();
//                bshInfoPointOfSale.setState(BottomSheetBehavior.STATE_EXPANDED);

                return true;
            }
        });
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(mDefaultLocation, 14f));
//
//        // Prompt the user for permission.
        getLocationPermission();

        // Get the current location of the device and set the position of the map.
        getDeviceLocation();

        // Turn on the My Location layer and the related control on the map.
//        updateLocationUI();

    }

    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(getContext(), "Click en una pos.", Toast.LENGTH_SHORT).show();
        map.addMarker(new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }

    //permite que la camara se mueva
    @Override
    public void onCameraIdle() {
        LatLng centerPoint = map.getCameraPosition().target;
        Log.d(TAG, "Lat: " + centerPoint.latitude + "___ Long: " + centerPoint.longitude);
        if (marker == null) {
            marker.remove();

            map.addMarker(new MarkerOptions()
                    .position(centerPoint)
                    .title(getStringAddress(centerPoint.latitude, centerPoint.longitude))
            );
        } else {
            marker.setPosition(centerPoint);
//            marker.setTitle(
//                    getStringAddress(centerPoint.latitude,centerPoint.longitude)
//            );
        }


    }

    public String getStringAddress(Double latitud, Double longitud) {
        String address = "";
//        String city = "";
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latitud, longitud, 1);
            if (addresses.size() > 0) {
                Address objAddress = addresses.get(0);
                address = objAddress.getAddressLine(0);
//            city = objAddress.getLocality();
            } else {
                address = "Desconocido";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }


    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(getContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }


    /**
     * Gets the current location of the device, and positions the map's camera.
     */
    private void getDeviceLocation() {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */
        if (mLocationPermissionGranted) {
            if (ActivityCompat.checkSelfPermission(
                    getContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(getContext(),
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Task<Location> locationResult = mFusedLocationProviderClient.getLastLocation();
            locationResult.addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful()) {
                        // Set the map's camera position to the current location of the device.
                        mLastKnownLocation = task.getResult();
                        if (mLastKnownLocation != null) {
                            latitud = mLastKnownLocation.getLatitude();
                            longitud = mLastKnownLocation.getLongitude();
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                    new LatLng(mLastKnownLocation.getLatitude(),
                                            mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                        }
                    } else {
                        Log.d(TAG, "Current location is null. Using defaults.");
                        Log.e(TAG, "Exception: %s", task.getException());
                        map.moveCamera(CameraUpdateFactory
                                .newLatLngZoom(mDefaultLocation, DEFAULT_ZOOM));
                        map.getUiSettings().setMyLocationButtonEnabled(false);
                    }
                }
            });
        }
    }

    /**
     * Handles the result of the request for location permissions.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
        updateLocationUI();
    }


        private void updateLocationUI () {
            if (map == null) {
                return;
            }
            try {
                if (mLocationPermissionGranted) {
                    map.setMyLocationEnabled(true);
                    map.getUiSettings().setMyLocationButtonEnabled(true);
                    map.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                        @Override
                        public boolean onMyLocationButtonClick() {
                            LatLng me = new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude());
                            map.animateCamera(CameraUpdateFactory.newLatLngZoom(me, 14f));
                            return false;
                        }
                    });
                } else {
                    map.setMyLocationEnabled(false);
                    map.getUiSettings().setMyLocationButtonEnabled(false);
                    mLastKnownLocation = null;
                    getLocationPermission();
                }
            } catch (SecurityException e) {
                Log.e("Exception: %s", e.getMessage());
            }
        }

}