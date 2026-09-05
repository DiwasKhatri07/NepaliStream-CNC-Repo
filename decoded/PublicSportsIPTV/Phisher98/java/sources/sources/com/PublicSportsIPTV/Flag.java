package com.PublicSportsIPTV;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PublicSportsIPTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/PublicSportsIPTV/Flag;", "", "src", "", "<init>", "(Ljava/lang/String;)V", "getSrc", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Flag {

    @NotNull
    private final String src;

    public static /* synthetic */ Flag copy$default(Flag flag, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = flag.src;
        }
        return flag.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @NotNull
    public final Flag copy(@NotNull String src) {
        return new Flag(src);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Flag) && Intrinsics.areEqual(this.src, ((Flag) other).src);
    }

    public int hashCode() {
        return this.src.hashCode();
    }

    @NotNull
    public String toString() {
        return "Flag(src=" + this.src + ')';
    }

    public Flag(@NotNull String src) {
        this.src = src;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }
}
