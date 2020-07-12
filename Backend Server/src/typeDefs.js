const { gql } = require("apollo-server");
const typeDefs = gql`
  type Donor {
    blodgroup: String
    identity_number: String
    namee: String
    ph: String
  }
  type Req {
    blodgroup: String
    phone: String
    rname: String
  }
type Query {
    donors: [Donor],
    req:[Req]
  }



`;
module.exports = typeDefs;


// blodgroup: data.blodgroup,
//     phone: data.phone,
//         rname: data.rname,
// //
// blodgroup: data.blodgroup,
//     identity_number: data.identity_number,
//         name_group: data.name_group,
//             namee: data.namee,
//                 ph: data.ph