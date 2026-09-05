package com.PublicSportsIPTV;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PublicSportsIPTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/PublicSportsIPTV/Cricket;", "", "isBatting", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Cricket {
    private final boolean isBatting;

    public static /* synthetic */ Cricket copy$default(Cricket cricket, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = cricket.isBatting;
        }
        return cricket.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsBatting() {
        return this.isBatting;
    }

    @NotNull
    public final Cricket copy(boolean isBatting) {
        return new Cricket(isBatting);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Cricket) && this.isBatting == ((Cricket) other).isBatting;
    }

    public int hashCode() {
        return Cricket$$ExternalSyntheticBackport0.m0m(this.isBatting);
    }

    @NotNull
    public String toString() {
        return "Cricket(isBatting=" + this.isBatting + ')';
    }

    public Cricket(boolean isBatting) {
        this.isBatting = isBatting;
    }

    public final boolean isBatting() {
        return this.isBatting;
    }
}
