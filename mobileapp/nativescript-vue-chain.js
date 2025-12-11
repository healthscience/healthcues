module.exports = (chain) => {
  // Ensure the ForkTsChecker plugin is defined before any taps
  if (!chain.plugins.has('ForkTsCheckerWebpackPlugin')) {
    try {
      const ForkTsCheckerWebpackPlugin = require('fork-ts-checker-webpack-plugin');
      chain.plugin('ForkTsCheckerWebpackPlugin').use(ForkTsCheckerWebpackPlugin, [{ async: false }]);
    } catch (e) {
      // ignore if not installed; not using TS
    }
  }
};
