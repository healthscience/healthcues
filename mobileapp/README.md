heathCues mobile app (NativeScript + Vue 3 + Vite)

Quick start

1) Install deps
   npm install

2) Run on Android device
   - Enable Developer Options + USB debugging on your phone
   - Connect via USB, ensure `adb devices` shows the device
   - Run: npm run dev:android

Project layout
- src/: app code (main.js, App.vue, app.css)
- test/: unit tests (vitest)
- App_Resources/: native platform configs

Notes
- Vite is configured via vite.config.mjs
- nativescript.config.js uses appPath: 'src' and bundler: 'vite'
- Android network security is configured for localhost dev/HMR
