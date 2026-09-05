package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IStreamFlare/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/IStreamFlare/SeasonRes;", "", "id", "", "Session_Name", "season_order", "web_series_id", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSession_Name", "getSeason_order", "getWeb_series_id", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeasonRes {

    @NotNull
    private final String Session_Name;

    @NotNull
    private final String id;

    @NotNull
    private final String season_order;

    @NotNull
    private final String status;

    @NotNull
    private final String web_series_id;

    public SeasonRes() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SeasonRes copy$default(SeasonRes seasonRes, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = seasonRes.id;
        }
        if ((i & 2) != 0) {
            str2 = seasonRes.Session_Name;
        }
        if ((i & 4) != 0) {
            str3 = seasonRes.season_order;
        }
        if ((i & 8) != 0) {
            str4 = seasonRes.web_series_id;
        }
        if ((i & 16) != 0) {
            str5 = seasonRes.status;
        }
        String str6 = str5;
        String str7 = str3;
        return seasonRes.copy(str, str2, str7, str4, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSession_Name() {
        return this.Session_Name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSeason_order() {
        return this.season_order;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getWeb_series_id() {
        return this.web_series_id;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final SeasonRes copy(@NotNull String id, @NotNull String Session_Name, @NotNull String season_order, @NotNull String web_series_id, @NotNull String status) {
        return new SeasonRes(id, Session_Name, season_order, web_series_id, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeasonRes)) {
            return false;
        }
        SeasonRes seasonRes = (SeasonRes) other;
        return Intrinsics.areEqual(this.id, seasonRes.id) && Intrinsics.areEqual(this.Session_Name, seasonRes.Session_Name) && Intrinsics.areEqual(this.season_order, seasonRes.season_order) && Intrinsics.areEqual(this.web_series_id, seasonRes.web_series_id) && Intrinsics.areEqual(this.status, seasonRes.status);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.Session_Name.hashCode()) * 31) + this.season_order.hashCode()) * 31) + this.web_series_id.hashCode()) * 31) + this.status.hashCode();
    }

    @NotNull
    public String toString() {
        return "SeasonRes(id=" + this.id + ", Session_Name=" + this.Session_Name + ", season_order=" + this.season_order + ", web_series_id=" + this.web_series_id + ", status=" + this.status + ')';
    }

    public SeasonRes(@NotNull String id, @NotNull String Session_Name, @NotNull String season_order, @NotNull String web_series_id, @NotNull String status) {
        this.id = id;
        this.Session_Name = Session_Name;
        this.season_order = season_order;
        this.web_series_id = web_series_id;
        this.status = status;
    }

    public /* synthetic */ SeasonRes(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getSession_Name() {
        return this.Session_Name;
    }

    @NotNull
    public final String getSeason_order() {
        return this.season_order;
    }

    @NotNull
    public final String getWeb_series_id() {
        return this.web_series_id;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }
}
