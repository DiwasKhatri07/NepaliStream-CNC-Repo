package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IdlixProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/idlix/SeasonWrapper;", "", "season", "Lcom/idlix/Season;", "<init>", "(Lcom/idlix/Season;)V", "getSeason", "()Lcom/idlix/Season;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeasonWrapper {

    @Nullable
    private final Season season;

    /* JADX WARN: Illegal instructions before constructor call */
    public SeasonWrapper() {
        Season season = null;
        this(season, 1, season);
    }

    public static /* synthetic */ SeasonWrapper copy$default(SeasonWrapper seasonWrapper, Season season, int i, Object obj) {
        if ((i & 1) != 0) {
            season = seasonWrapper.season;
        }
        return seasonWrapper.copy(season);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Season getSeason() {
        return this.season;
    }

    @NotNull
    public final SeasonWrapper copy(@Nullable Season season) {
        return new SeasonWrapper(season);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SeasonWrapper) && Intrinsics.areEqual(this.season, ((SeasonWrapper) other).season);
    }

    public int hashCode() {
        if (this.season == null) {
            return 0;
        }
        return this.season.hashCode();
    }

    @NotNull
    public String toString() {
        return "SeasonWrapper(season=" + this.season + ')';
    }

    public SeasonWrapper(@Nullable Season season) {
        this.season = season;
    }

    public /* synthetic */ SeasonWrapper(Season season, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : season);
    }

    @Nullable
    public final Season getSeason() {
        return this.season;
    }
}
