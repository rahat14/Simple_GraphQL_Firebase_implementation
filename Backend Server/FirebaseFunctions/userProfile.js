function userProfile(data) {
    return {
        blodgroup: data.blodgroup,
        identity_number: data.identity_number,
        name_group: data.name_group,
        namee: data.namee,
        ph: data.ph
    };
}
module.exports = userProfile;