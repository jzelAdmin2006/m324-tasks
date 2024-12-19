import globals from 'globals';
import pluginJs from '@eslint/js';
// output current configuration
// console.log("pluginJs.configs.recommended", pluginJs.configs.recommended);
export default [
  {
    languageOptions: {
      globals: {
        ...globals.browser,
        ...globals.mocha,
      },
    },
  },
  pluginJs.configs.recommended,
  {
    rules: {
      eqeqeq: ['error', 'always'], // Enforce === and !== over == and !=
      'no-var': 'error', // Disallow the use of var
    },
  },
];
