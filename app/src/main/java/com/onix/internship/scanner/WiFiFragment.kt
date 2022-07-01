package com.onix.internship.scanner

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FragmentWiFiBinding
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class WiFiFragment : BaseFragment<FragmentWiFiBinding>(R.layout.fragment_wi_fi){
    override val viewModel: SplashViewModel by viewModel()
    lateinit var wifiManager: WifiManager
    private var listView: ListView = TODO()
    private val arrayList = arrayListOf<String>()
     var adapter: ArrayAdapter<String>
     var results: List<ScanResult>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wifiManager = context!!.getSystemService(Context.WIFI_SERVICE) as WifiManager
        adapter = ArrayAdapter(requireContext(), R.layout.item, arrayList)
        listView.adapter = adapter
        if (wifiManager.isWifiEnabled) {
          Toast.makeText(context, "WiFi  disabled ", Toast.LENGTH_SHORT).show()
            wifiManager.isWifiEnabled

        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission
                (android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION), 0)
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            scanWifi()
        }

        binding.btnScan.setOnClickListener { scanWifi() }
    }

    private fun checkSelfPermission(accessCoarseLocation: String): Int {
        TODO("Not yet implemented")
    }

    private fun scanWifi() {
        arrayList.clear()
        context?.registerReceiver(wifiReceiver, IntentFilter
            (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        wifiManager.scanResults
        Toast.makeText(context, "Scanning WiFi", Toast.LENGTH_SHORT).show()
    }
    private val wifiReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            results = wifiManager.scanResults
           context.unregisterReceiver(this)
            for (scanResult in results) {
                val wifiSsid = scanResult.SSID
                val wifi_ssid_first_nine_characters = if (wifiSsid.length < 9) {
                    wifiSsid.substring(0, 9)
                } else {
                    wifiSsid
                }
                arrayList.add(scanResult.SSID + " - " + scanResult.capabilities)
                adapter.notifyDataSetChanged()
            }

        }
    }
}