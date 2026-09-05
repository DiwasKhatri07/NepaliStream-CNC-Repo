package com.PublicSportsIPTV;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PublicSportsIPTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0095\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000fHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006&"}, d2 = {"Lcom/PublicSportsIPTV/StreamingCdn;", "", "language", "", "primaryPlaybackUrl", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Primary_Playback_URL", "fancodeCdn", "fancode_cdn", "daiGoogleCdn", "dai_google_cdn", "cloudfrontCdn", "cloudfront_cdn", "sonyCdn", "sony_cdn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getPrimaryPlaybackUrl", "getFancodeCdn", "getDaiGoogleCdn", "getCloudfrontCdn", "getSonyCdn", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class StreamingCdn {

    @Nullable
    private final String cloudfrontCdn;

    @Nullable
    private final String daiGoogleCdn;

    @Nullable
    private final String fancodeCdn;

    @NotNull
    private final String language;

    @Nullable
    private final String primaryPlaybackUrl;

    @Nullable
    private final String sonyCdn;

    public static /* synthetic */ StreamingCdn copy$default(StreamingCdn streamingCdn, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamingCdn.language;
        }
        if ((i & 2) != 0) {
            str2 = streamingCdn.primaryPlaybackUrl;
        }
        if ((i & 4) != 0) {
            str3 = streamingCdn.fancodeCdn;
        }
        if ((i & 8) != 0) {
            str4 = streamingCdn.daiGoogleCdn;
        }
        if ((i & 16) != 0) {
            str5 = streamingCdn.cloudfrontCdn;
        }
        if ((i & 32) != 0) {
            str6 = streamingCdn.sonyCdn;
        }
        String str7 = str5;
        String str8 = str6;
        return streamingCdn.copy(str, str2, str3, str4, str7, str8);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPrimaryPlaybackUrl() {
        return this.primaryPlaybackUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFancodeCdn() {
        return this.fancodeCdn;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDaiGoogleCdn() {
        return this.daiGoogleCdn;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCloudfrontCdn() {
        return this.cloudfrontCdn;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSonyCdn() {
        return this.sonyCdn;
    }

    @NotNull
    public final StreamingCdn copy(@NotNull String language, @JsonProperty("Primary_Playback_URL") @Nullable String primaryPlaybackUrl, @JsonProperty("fancode_cdn") @Nullable String fancodeCdn, @JsonProperty("dai_google_cdn") @Nullable String daiGoogleCdn, @JsonProperty("cloudfront_cdn") @Nullable String cloudfrontCdn, @JsonProperty("sony_cdn") @Nullable String sonyCdn) {
        return new StreamingCdn(language, primaryPlaybackUrl, fancodeCdn, daiGoogleCdn, cloudfrontCdn, sonyCdn);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamingCdn)) {
            return false;
        }
        StreamingCdn streamingCdn = (StreamingCdn) other;
        return Intrinsics.areEqual(this.language, streamingCdn.language) && Intrinsics.areEqual(this.primaryPlaybackUrl, streamingCdn.primaryPlaybackUrl) && Intrinsics.areEqual(this.fancodeCdn, streamingCdn.fancodeCdn) && Intrinsics.areEqual(this.daiGoogleCdn, streamingCdn.daiGoogleCdn) && Intrinsics.areEqual(this.cloudfrontCdn, streamingCdn.cloudfrontCdn) && Intrinsics.areEqual(this.sonyCdn, streamingCdn.sonyCdn);
    }

    public int hashCode() {
        return (((((((((this.language.hashCode() * 31) + (this.primaryPlaybackUrl == null ? 0 : this.primaryPlaybackUrl.hashCode())) * 31) + (this.fancodeCdn == null ? 0 : this.fancodeCdn.hashCode())) * 31) + (this.daiGoogleCdn == null ? 0 : this.daiGoogleCdn.hashCode())) * 31) + (this.cloudfrontCdn == null ? 0 : this.cloudfrontCdn.hashCode())) * 31) + (this.sonyCdn != null ? this.sonyCdn.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "StreamingCdn(language=" + this.language + ", primaryPlaybackUrl=" + this.primaryPlaybackUrl + ", fancodeCdn=" + this.fancodeCdn + ", daiGoogleCdn=" + this.daiGoogleCdn + ", cloudfrontCdn=" + this.cloudfrontCdn + ", sonyCdn=" + this.sonyCdn + ')';
    }

    public StreamingCdn(@NotNull String language, @JsonProperty("Primary_Playback_URL") @Nullable String primaryPlaybackUrl, @JsonProperty("fancode_cdn") @Nullable String fancodeCdn, @JsonProperty("dai_google_cdn") @Nullable String daiGoogleCdn, @JsonProperty("cloudfront_cdn") @Nullable String cloudfrontCdn, @JsonProperty("sony_cdn") @Nullable String sonyCdn) {
        this.language = language;
        this.primaryPlaybackUrl = primaryPlaybackUrl;
        this.fancodeCdn = fancodeCdn;
        this.daiGoogleCdn = daiGoogleCdn;
        this.cloudfrontCdn = cloudfrontCdn;
        this.sonyCdn = sonyCdn;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
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
    public final String getSonyCdn() {
        return this.sonyCdn;
    }
}
