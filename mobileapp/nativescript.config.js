/** @type {import('@nativescript/types').NativeScriptConfig} */
module.exports = {
  id: 'com.healthscience.healthcues',
  appPath: 'src',
  appResourcesPath: 'App_Resources',
  name: 'heathCues',
  android: {
    discardUncaughtJsExceptions: false
  },
  ios: {},
  // Allow switching bundlers via env: NS_BUNDLER=webpack or NS_BUNDLER=vite
  bundler: process.env.NS_BUNDLER || 'vite',
  bundlerConfigPath: process.env.NS_BUNDLER === 'vite' || !process.env.NS_BUNDLER ? 'vite.config.mjs' : undefined
};
