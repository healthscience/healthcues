import { defineConfig, mergeConfig } from 'vite';
import { vueConfig } from '@nativescript/vite';

const stubAngular = () => ({
  name: 'stub-angular',
  resolveId(id) {
    if (id === '@angular/core') return '\0angular-core-stub';
    if (id === '@nativescript/angular') return '\0ns-angular-stub';
  },
  load(id) {
    if (id === '\0angular-core-stub') {
      return `export const isDevMode = () => true;\nexport const \u0275resetCompiledComponents = () => {};\nexport default {};`;
    }
    if (id === '\0ns-angular-stub') {
      return `export default {};`;
    }
  }
});

export default defineConfig(({ mode }) => mergeConfig(vueConfig({ mode }), {
  plugins: [stubAngular()],
  optimizeDeps: { disabled: true }
}));
