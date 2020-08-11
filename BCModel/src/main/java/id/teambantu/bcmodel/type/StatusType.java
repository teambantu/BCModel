package id.teambantu.bcmodel.type;

public enum StatusType {
    ORDER_PLACED,       // user place order
    ORDER_CONFIRMED,    // mitra accept the order
    ORDER_PICKING,      // mitra pick up the order and go to user place
    ORDER_PICKED_UP,    // mitra has pick the order
    ORDER_WASHING,      // mitra washing the order
    OEDER_WASHED,       // mitra has washed the order
    ORDER_DELIVERING,   // mitra deliver the order
    ORDER_DELIVERED,    // mitra has deliver the order
    ORDER_FINISHED,     // order finish
    ORDER_CANCELED_BY_USER,
    ORDER_CANCELED_BY_MITRA,
    ORDER_CANCELED_BY_SYSTEM,
    NONE
}
