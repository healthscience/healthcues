import type { NativeScriptConfig } from '@nativescript/core';
export default {
  id: 'org.healthscience.healthcues_bb',
  appPath: 'src',
  appResourcesPath: 'App_Resources',
  android: { v8Flags: '--expose_gc', markingMode: 'none' },
  bundler: 'vite'
} satisfies NativeScriptConfig;
