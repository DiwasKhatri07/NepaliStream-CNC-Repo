package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/phisher98/AnichiStream;", "", "format", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "audio_lang", "hardsub_lang", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFormat", "()Ljava/lang/String;", "getAudio_lang", "getHardsub_lang", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiStream {

    @Nullable
    private final String audio_lang;

    @Nullable
    private final String format;

    @Nullable
    private final String hardsub_lang;

    @Nullable
    private final String url;

    public AnichiStream() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AnichiStream copy$default(AnichiStream anichiStream, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anichiStream.format;
        }
        if ((i & 2) != 0) {
            str2 = anichiStream.audio_lang;
        }
        if ((i & 4) != 0) {
            str3 = anichiStream.hardsub_lang;
        }
        if ((i & 8) != 0) {
            str4 = anichiStream.url;
        }
        return anichiStream.copy(str, str2, str3, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAudio_lang() {
        return this.audio_lang;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHardsub_lang() {
        return this.hardsub_lang;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final AnichiStream copy(@JsonProperty("format") @Nullable String format, @JsonProperty("audio_lang") @Nullable String audio_lang, @JsonProperty("hardsub_lang") @Nullable String hardsub_lang, @JsonProperty("url") @Nullable String url) {
        return new AnichiStream(format, audio_lang, hardsub_lang, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnichiStream)) {
            return false;
        }
        AnichiStream anichiStream = (AnichiStream) other;
        return Intrinsics.areEqual(this.format, anichiStream.format) && Intrinsics.areEqual(this.audio_lang, anichiStream.audio_lang) && Intrinsics.areEqual(this.hardsub_lang, anichiStream.hardsub_lang) && Intrinsics.areEqual(this.url, anichiStream.url);
    }

    public int hashCode() {
        return ((((((this.format == null ? 0 : this.format.hashCode()) * 31) + (this.audio_lang == null ? 0 : this.audio_lang.hashCode())) * 31) + (this.hardsub_lang == null ? 0 : this.hardsub_lang.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnichiStream(format=" + this.format + ", audio_lang=" + this.audio_lang + ", hardsub_lang=" + this.hardsub_lang + ", url=" + this.url + ')';
    }

    public AnichiStream(@JsonProperty("format") @Nullable String format, @JsonProperty("audio_lang") @Nullable String audio_lang, @JsonProperty("hardsub_lang") @Nullable String hardsub_lang, @JsonProperty("url") @Nullable String url) {
        this.format = format;
        this.audio_lang = audio_lang;
        this.hardsub_lang = hardsub_lang;
        this.url = url;
    }

    public /* synthetic */ AnichiStream(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @Nullable
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    public final String getAudio_lang() {
        return this.audio_lang;
    }

    @Nullable
    public final String getHardsub_lang() {
        return this.hardsub_lang;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
