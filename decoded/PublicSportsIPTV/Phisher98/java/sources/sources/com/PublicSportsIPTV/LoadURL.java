package com.PublicSportsIPTV;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PublicSportsIPTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J¿\u0001\u0010!\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000fHÆ\u0001J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006("}, d2 = {"Lcom/PublicSportsIPTV/LoadURL;", "", "primaryPlaybackUrl", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Primary_Playback_URL", "fancodeCdn", "fancode_cdn", "daiGoogleCdn", "dai_google_cdn", "cloudfrontCdn", "cloudfront_cdn", "title", "tournament", "poster", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPrimaryPlaybackUrl", "()Ljava/lang/String;", "getFancodeCdn", "getDaiGoogleCdn", "getCloudfrontCdn", "getTitle", "getTournament", "getPoster", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadURL {

    @Nullable
    private final String cloudfrontCdn;

    @Nullable
    private final String daiGoogleCdn;

    @Nullable
    private final String fancodeCdn;

    @Nullable
    private final String poster;

    @Nullable
    private final String primaryPlaybackUrl;

    @Nullable
    private final String title;

    @Nullable
    private final String tournament;

    public static /* synthetic */ LoadURL copy$default(LoadURL loadURL, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadURL.primaryPlaybackUrl;
        }
        if ((i & 2) != 0) {
            str2 = loadURL.fancodeCdn;
        }
        if ((i & 4) != 0) {
            str3 = loadURL.daiGoogleCdn;
        }
        if ((i & 8) != 0) {
            str4 = loadURL.cloudfrontCdn;
        }
        if ((i & 16) != 0) {
            str5 = loadURL.title;
        }
        if ((i & 32) != 0) {
            str6 = loadURL.tournament;
        }
        if ((i & 64) != 0) {
            str7 = loadURL.poster;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return loadURL.copy(str, str2, str11, str4, str10, str8, str9);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPrimaryPlaybackUrl() {
        return this.primaryPlaybackUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFancodeCdn() {
        return this.fancodeCdn;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDaiGoogleCdn() {
        return this.daiGoogleCdn;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCloudfrontCdn() {
        return this.cloudfrontCdn;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTournament() {
        return this.tournament;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @NotNull
    public final LoadURL copy(@JsonProperty("Primary_Playback_URL") @Nullable String primaryPlaybackUrl, @JsonProperty("fancode_cdn") @Nullable String fancodeCdn, @JsonProperty("dai_google_cdn") @Nullable String daiGoogleCdn, @JsonProperty("cloudfront_cdn") @Nullable String cloudfrontCdn, @JsonProperty("title") @Nullable String title, @JsonProperty("tournament") @Nullable String tournament, @JsonProperty("poster") @Nullable String poster) {
        return new LoadURL(primaryPlaybackUrl, fancodeCdn, daiGoogleCdn, cloudfrontCdn, title, tournament, poster);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadURL)) {
            return false;
        }
        LoadURL loadURL = (LoadURL) other;
        return Intrinsics.areEqual(this.primaryPlaybackUrl, loadURL.primaryPlaybackUrl) && Intrinsics.areEqual(this.fancodeCdn, loadURL.fancodeCdn) && Intrinsics.areEqual(this.daiGoogleCdn, loadURL.daiGoogleCdn) && Intrinsics.areEqual(this.cloudfrontCdn, loadURL.cloudfrontCdn) && Intrinsics.areEqual(this.title, loadURL.title) && Intrinsics.areEqual(this.tournament, loadURL.tournament) && Intrinsics.areEqual(this.poster, loadURL.poster);
    }

    public int hashCode() {
        return ((((((((((((this.primaryPlaybackUrl == null ? 0 : this.primaryPlaybackUrl.hashCode()) * 31) + (this.fancodeCdn == null ? 0 : this.fancodeCdn.hashCode())) * 31) + (this.daiGoogleCdn == null ? 0 : this.daiGoogleCdn.hashCode())) * 31) + (this.cloudfrontCdn == null ? 0 : this.cloudfrontCdn.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.tournament == null ? 0 : this.tournament.hashCode())) * 31) + (this.poster != null ? this.poster.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LoadURL(primaryPlaybackUrl=" + this.primaryPlaybackUrl + ", fancodeCdn=" + this.fancodeCdn + ", daiGoogleCdn=" + this.daiGoogleCdn + ", cloudfrontCdn=" + this.cloudfrontCdn + ", title=" + this.title + ", tournament=" + this.tournament + ", poster=" + this.poster + ')';
    }

    public LoadURL(@JsonProperty("Primary_Playback_URL") @Nullable String primaryPlaybackUrl, @JsonProperty("fancode_cdn") @Nullable String fancodeCdn, @JsonProperty("dai_google_cdn") @Nullable String daiGoogleCdn, @JsonProperty("cloudfront_cdn") @Nullable String cloudfrontCdn, @JsonProperty("title") @Nullable String title, @JsonProperty("tournament") @Nullable String tournament, @JsonProperty("poster") @Nullable String poster) {
        this.primaryPlaybackUrl = primaryPlaybackUrl;
        this.fancodeCdn = fancodeCdn;
        this.daiGoogleCdn = daiGoogleCdn;
        this.cloudfrontCdn = cloudfrontCdn;
        this.title = title;
        this.tournament = tournament;
        this.poster = poster;
    }

    @Nullable
    public final String getPrimaryPlaybackUrl() {
        return this.primaryPlaybackUrl;
    }

    @Nullable
    public final String getFancodeCdn() {
        return this.fancodeCdn;
    }

    @Nullable
    public final String getDaiGoogleCdn() {
        return this.daiGoogleCdn;
    }

    @Nullable
    public final String getCloudfrontCdn() {
        return this.cloudfrontCdn;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTournament() {
        return this.tournament;
    }

    @Nullable
    public final String getPoster() {
        return this.poster;
    }
}
