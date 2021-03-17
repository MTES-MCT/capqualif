package fr.gouv.mte.capqualif.legislateur.mock;

// For reference, see : https://stackoverflow.com/a/8811869

public enum Position {

    // Starts from the farthest parent.
    // Real world example :
    //
    //      great great parent      POSITION_1
    //      great parent            POSITION_2
    //      parent                  POSITION_3

    POSITION_1(1),
    POSITION_2 (2),
    POSITION_3 (3),
    POSITION_4 (4),
    POSITION_5 (5);

    private int numVal;

    Position(int numVal) {
        this.numVal = numVal;
    }
}
