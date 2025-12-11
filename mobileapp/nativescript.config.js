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
  bundler: 'vite',
  bundlerConfigPath: 'vite.config.mjs'
};
