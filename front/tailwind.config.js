/** @type {import('tailwindcss').Config} */

module.exports = {
  plugins: [require("@tailwindcss/forms"), require("preline/plugin")],
  content: ["./src/**/*.{html,ts}", "node_modules/preline/dist/*.js"],
  darkMode: "class",
  theme: {
    fontFamily: {
      marianne: ["Marianne", "system-ui"],
      poppins: ["Poppins", "system-ui"],
    },
    colors: {
      transparent: "transparent",
      current: "currentColor",
      white: "#ffffff",
      black: "#030a1e",
      gray: {
        50: "#f9fafb",
        100: "#f3f4f6",
        200: "#e5e7eb",
        300: "#d1d5db",
        400: "#9ca3af",
        500: "#6b7280",
        600: "#4b5563",
        700: "#374151",
        800: "#1f2937",
        900: "#111827",
        950: "#030712",
      },
      primary: {
        50: "#f0f9ff",
        100: "#dff1ff",
        200: "#b9e5fe",
        300: "#7bd1fe",
        400: "#34bafc",
        500: "#0aa2ed",
        600: "#0081cb",
        700: "#0064a0",
        800: "#055787",
        900: "#0a4870",
        950: "#072e4a",
      },
      secondary: {
        50: "#fffbea",
        100: "#fff2c5",
        200: "#ffe685",
        300: "#ffd246",
        400: "#ffbd1b",
        500: "#fd9800",
        600: "#e27200",
        700: "#bb4d02",
        800: "#983b08",
        900: "#7c310b",
        950: "#481700",
      },
      green: {
        50: "#ecfdf5",
        100: "#d1fae5",
        200: "#a7f3d0",
        300: "#6ee7b7",
        400: "#34d399",
        500: "#10b981",
        600: "#059669",
        700: "#047857",
        800: "#065f46",
        900: "#064e3b",
        950: "#022c22",
      },
      red: {
        50: "#fef2f2",
        100: "#fee2e2",
        200: "#fecaca",
        300: "#fca5a5",
        400: "#f87171",
        500: "#ef4444",
        600: "#dc2626",
        700: "#b91c1c",
        800: "#991b1b",
        900: "#7f1d1d",
        950: "#450a0a",
      },
    },
  },
};
