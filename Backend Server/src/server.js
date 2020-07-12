const express = require("express");
const { ApolloServer } = require("apollo-server-express");
const firebase = require("firebase");
require("dotenv").config();
const typeDefs = require("./typeDefs");
const resolvers = require("./resolvers");
const app = express();



const firebaseClient = firebase.initializeApp({
    apiKey: "YOUR_API_KEY",
    authDomain: "YOUR_AUTH_DOMAIN",
    databaseURL: "YOUR_DATABASE_URL",
    projectId: "YOUR_PROJECT_ID" // find all this from u r firebase console .
});

const server = new ApolloServer({
    typeDefs,
    resolvers,
    context: ({ req }) => {
        return {
            headers: req.headers,
            firebaseClient
        };
    }
});


server.applyMiddleware({ app });

app.listen({ port: 4000 }, () => {
    console.log("Server has started 🚀 http://localhost:4000/graphql");
});