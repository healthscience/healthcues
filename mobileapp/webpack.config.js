const webpack = require('@nativescript/webpack');

module.exports = (env) => {
  webpack.init(env);
  // Minimal config; framework detection handled by @nativescript/webpack
  // Avoid chaining Vue-specific tweaks that expect TypeScript plugins.
  return webpack.resolveConfig();
};
