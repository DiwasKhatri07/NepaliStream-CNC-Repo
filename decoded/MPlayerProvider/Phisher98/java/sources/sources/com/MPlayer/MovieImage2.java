package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003JS\u0010\u0015\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/MPlayer/MovieImage2;", "", "n16x9", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "16x9", "n2x3", "2x3", "n1x1", "1x1", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getN16x9", "()Ljava/lang/String;", "getN2x3", "getN1x1", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieImage2 {

    @NotNull
    private final String n16x9;

    @Nullable
    private final Object n1x1;

    @NotNull
    private final String n2x3;

    public static /* synthetic */ MovieImage2 copy$default(MovieImage2 movieImage2, String str, String str2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = movieImage2.n16x9;
        }
        if ((i & 2) != 0) {
            str2 = movieImage2.n2x3;
        }
        if ((i & 4) != 0) {
            obj = movieImage2.n1x1;
        }
        return movieImage2.copy(str, str2, obj);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getN16x9() {
        return this.n16x9;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getN2x3() {
        return this.n2x3;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getN1x1() {
        return this.n1x1;
    }

    @NotNull
    public final MovieImage2 copy(@JsonProperty("16x9") @NotNull String n16x9, @JsonProperty("2x3") @NotNull String n2x3, @JsonProperty("1x1") @Nullable Object n1x1) {
        return new MovieImage2(n16x9, n2x3, n1x1);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieImage2)) {
            return false;
        }
        MovieImage2 movieImage2 = (MovieImage2) other;
        return Intrinsics.areEqual(this.n16x9, movieImage2.n16x9) && Intrinsics.areEqual(this.n2x3, movieImage2.n2x3) && Intrinsics.areEqual(this.n1x1, movieImage2.n1x1);
    }

    public int hashCode() {
        return (((this.n16x9.hashCode() * 31) + this.n2x3.hashCode()) * 31) + (this.n1x1 == null ? 0 : this.n1x1.hashCode());
    }

    @NotNull
    public String toString() {
        return "MovieImage2(n16x9=" + this.n16x9 + ", n2x3=" + this.n2x3 + ", n1x1=" + this.n1x1 + ')';
    }

    public MovieImage2(@JsonProperty("16x9") @NotNull String n16x9, @JsonProperty("2x3") @NotNull String n2x3, @JsonProperty("1x1") @Nullable Object n1x1) {
        this.n16x9 = n16x9;
        this.n2x3 = n2x3;
        this.n1x1 = n1x1;
    }

    @NotNull
    public final String getN16x9() {
        return this.n16x9;
    }

    @NotNull
    public final String getN2x3() {
        return this.n2x3;
    }

    @Nullable
    public final Object getN1x1() {
        return this.n1x1;
    }
}
