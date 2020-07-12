const userProfile = require("../FirebaseFunctions/userProfile");
const bloodReq = require("../FirebaseFunctions/bloodReq");

const baseURL = "https://budonor.firebaseio.com"  ;




const resolvers = {
    Query: {
        donors: async () => {
            const data = await fetch(`${baseURL}/donor.json`);
            const dataJson = await data.json();
            const keys = Object.keys(dataJson);
            const mapsKeys = keys.map(function (item) {
                const userData = dataJson[item];
        
                const graphqlUser = userProfile(userData);
                return graphqlUser;
            });
            return mapsKeys;
        } , 

        req : async () => {
            const data = await fetch(`${baseURL}/BloodReq.json`);
            const dataJson = await data.json();
            const keys = Object.keys(dataJson);
            const mapsKeys = keys.map(function (item) {
                const userData = dataJson[item];

                const graphqlUser = bloodReq(userData);
                return graphqlUser;
            });
            return mapsKeys;
        }
        
    }
};

module.exports = resolvers;