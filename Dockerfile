FROM node:alpine
WORKDIR /app
COPY ./index.js ./index.js
COPY ./node_modules ./node_modules
EXPOSE 3000
CMD ["node", "./index.js"]
