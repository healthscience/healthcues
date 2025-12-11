const webpack = require('@nativescript/webpack');

module.exports = (env) => {
  webpack.init(env);
  webpack.useConfig('angular', false);
  webpack.useConfig('vue', true);
  webpack.chainWebpack((config) => {
    // Keep it simple; default @nativescript/webpack handles most cases.
  });
  return webpack.resolveConfig();
};
