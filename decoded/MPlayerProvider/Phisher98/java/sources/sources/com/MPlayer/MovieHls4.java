package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/MPlayer/MovieHls4;", "", "high", "", "base", "main", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getHigh", "()Ljava/lang/String;", "getBase", "()Ljava/lang/Object;", "getMain", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieHls4 {

    @Nullable
    private final Object base;

    @NotNull
    private final String high;

    @Nullable
    private final Object main;

    public static /* synthetic */ MovieHls4 copy$default(MovieHls4 movieHls4, String str, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            str = movieHls4.high;
        }
        if ((i & 2) != 0) {
            obj = movieHls4.base;
        }
        if ((i & 4) != 0) {
            obj2 = movieHls4.main;
        }
        return movieHls4.copy(str, obj, obj2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHigh() {
        return this.high;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getBase() {
        return this.base;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getMain() {
        return this.main;
    }

    @NotNull
    public final MovieHls4 copy(@NotNull String high, @Nullable Object base, @Nullable Object main) {
        return new MovieHls4(high, base, main);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieHls4)) {
            return false;
        }
        MovieHls4 movieHls4 = (MovieHls4) other;
        return Intrinsics.areEqual(this.high, movieHls4.high) && Intrinsics.areEqual(this.base, movieHls4.base) && Intrinsics.areEqual(this.main, movieHls4.main);
    }

    public int hashCode() {
        return (((this.high.hashCode() * 31) + (this.base == null ? 0 : this.base.hashCode())) * 31) + (this.main != null ? this.main.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MovieHls4(high=" + this.high + ", base=" + this.base + ", main=" + this.main + ')';
    }

    public MovieHls4(@NotNull String high, @Nullable Object base, @Nullable Object main) {
        this.high = high;
        this.base = base;
        this.main = main;
    }

    @NotNull
    public final String getHigh() {
        return this.high;
    }

    @Nullable
    public final Object getBase() {
        return this.base;
    }

    @Nullable
    public final Object getMain() {
        return this.main;
    }
}
