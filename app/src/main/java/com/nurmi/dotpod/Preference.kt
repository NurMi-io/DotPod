PreferenceGroup {
  Preference("bug_reports", "Bug Reports") {
  iconStyle = MaterialComponents.IconStyle() // Customize icon style
  colorPrimary = MaterialComponents.colors.primary // Set primary color
  }
   
  Preference("support_thanks", "Support Thanks") {

    val bannerAd = AdMobAds.bannerAd(adUnitId = "YourAdUnitID")
  ...
  }
  
  ...
}
