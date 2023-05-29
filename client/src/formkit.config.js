// export default {
//     iconLoaderUrl: (iconName) => `https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free/svgs/solid/${iconName}.svg`
//   }

// import { createProPlugin, rating, toggle, dropdown } from '@formit/pro'
// const proPlugin = createProPlugin('fk-577218191f7', {
//           rating,
//           toggle,
//           dropdown
//           // ... and any other Pro Inputs
//         })

//   const config = defaultConfig({
//     plugins: [proPlugin],
//   });
  
//   export default config;

import "@formkit/themes/genesis"
import { genesisIcons } from "@formkit/icons"
import { createProPlugin, inputs, dropdown,rating } from '@formkit/pro'
import '@formkit/pro/genesis'

const pro = createProPlugin('fk-577218191f7', inputs, dropdown,rating)

const config = {
  plugins: [pro],
  icons: { ...genesisIcons }
}

export default config