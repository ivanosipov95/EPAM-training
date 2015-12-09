package javase02.t05;

public enum Subject {

    MATHEMATICS {
        @Override
        public Integer set(Number mark) throws IllegalArgumentException {
            if (mark instanceof Integer) {
                return (Integer) mark;
            } else {
                throw new IllegalArgumentException("argument of parse() has to be int");
            }
        }
    },

    OOP {
        @Override
        public Double set(Number mark) throws IllegalArgumentException {
            if (mark instanceof Double) {
                return (Double) mark;
            } else {
                throw new IllegalArgumentException("argument of parse() has to be double");
            }
        }
    },

    OS {
        @Override
        public Integer set(Number mark) throws IllegalArgumentException {
            if (mark instanceof Integer) {
                return (Integer) mark;
            } else {
                throw new IllegalArgumentException("argument of parse() has to be int");
            }
        }
    },

    DATABASE {
        @Override
        public Double set(Number mark) throws IllegalArgumentException {
            if (mark instanceof Double) {
                return (Double) mark;
            } else {
                throw new IllegalArgumentException("argument of parse() has to be double");
            }
        }
    };

    public abstract Number set(Number mark) throws IllegalArgumentException;

}
