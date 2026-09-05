package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jv\u0010\u0019\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/phisher98/Seasons;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "seasonNumber", "season_number", "airDate", "air_date", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getSeasonNumber", "getAirDate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/Seasons;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Seasons {

    @Nullable
    private final String airDate;

    @Nullable
    private final Integer id;

    @Nullable
    private final String name;

    @Nullable
    private final Integer seasonNumber;

    public Seasons() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Seasons copy$default(Seasons seasons, Integer num, String str, Integer num2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = seasons.id;
        }
        if ((i & 2) != 0) {
            str = seasons.name;
        }
        if ((i & 4) != 0) {
            num2 = seasons.seasonNumber;
        }
        if ((i & 8) != 0) {
            str2 = seasons.airDate;
        }
        return seasons.copy(num, str, num2, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAirDate() {
        return this.airDate;
    }

    @NotNull
    public final Seasons copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("air_date") @Nullable String airDate) {
        return new Seasons(id, name, seasonNumber, airDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Seasons)) {
            return false;
        }
        Seasons seasons = (Seasons) other;
        return Intrinsics.areEqual(this.id, seasons.id) && Intrinsics.areEqual(this.name, seasons.name) && Intrinsics.areEqual(this.seasonNumber, seasons.seasonNumber) && Intrinsics.areEqual(this.airDate, seasons.airDate);
    }

    public int hashCode() {
        return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.airDate != null ? this.airDate.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Seasons(id=" + this.id + ", name=" + this.name + ", seasonNumber=" + this.seasonNumber + ", airDate=" + this.airDate + ')';
    }

    public Seasons(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("air_date") @Nullable String airDate) {
        this.id = id;
        this.name = name;
        this.seasonNumber = seasonNumber;
        this.airDate = airDate;
    }

    public /* synthetic */ Seasons(Integer num, String str, Integer num2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    public final String getAirDate() {
        return this.airDate;
    }
}
