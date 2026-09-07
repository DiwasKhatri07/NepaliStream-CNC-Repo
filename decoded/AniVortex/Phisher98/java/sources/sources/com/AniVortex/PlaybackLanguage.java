package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003Jw\u0010\u001a\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\fHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R'\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R-\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0007\u0010\u0002¨\u0006!"}, d2 = {"Lcom/AniVortex/PlaybackLanguage;", "", "code", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "playback", "Lcom/AniVortex/PlaybackStreams;", "downloadOptions", "", "Lcom/AniVortex/DownloadOption;", "download_options", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/AniVortex/PlaybackStreams;Ljava/util/List;)V", "getCode", "()Ljava/lang/String;", "getName", "getPlayback", "()Lcom/AniVortex/PlaybackStreams;", "getDownloadOptions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PlaybackLanguage {

    @JsonProperty("code")
    @Nullable
    private final String code;

    @JsonProperty("download_options")
    @Nullable
    private final List<DownloadOption> downloadOptions;

    @JsonProperty("name")
    @Nullable
    private final String name;

    @JsonProperty("playback")
    @Nullable
    private final PlaybackStreams playback;

    public PlaybackLanguage() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaybackLanguage copy$default(PlaybackLanguage playbackLanguage, String str, String str2, PlaybackStreams playbackStreams, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playbackLanguage.code;
        }
        if ((i & 2) != 0) {
            str2 = playbackLanguage.name;
        }
        if ((i & 4) != 0) {
            playbackStreams = playbackLanguage.playback;
        }
        if ((i & 8) != 0) {
            list = playbackLanguage.downloadOptions;
        }
        return playbackLanguage.copy(str, str2, playbackStreams, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PlaybackStreams getPlayback() {
        return this.playback;
    }

    @Nullable
    public final List<DownloadOption> component4() {
        return this.downloadOptions;
    }

    @NotNull
    public final PlaybackLanguage copy(@JsonProperty("code") @Nullable String code, @JsonProperty("name") @Nullable String name, @JsonProperty("playback") @Nullable PlaybackStreams playback, @JsonProperty("download_options") @Nullable List<DownloadOption> downloadOptions) {
        return new PlaybackLanguage(code, name, playback, downloadOptions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaybackLanguage)) {
            return false;
        }
        PlaybackLanguage playbackLanguage = (PlaybackLanguage) other;
        return Intrinsics.areEqual(this.code, playbackLanguage.code) && Intrinsics.areEqual(this.name, playbackLanguage.name) && Intrinsics.areEqual(this.playback, playbackLanguage.playback) && Intrinsics.areEqual(this.downloadOptions, playbackLanguage.downloadOptions);
    }

    public int hashCode() {
        return ((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.playback == null ? 0 : this.playback.hashCode())) * 31) + (this.downloadOptions != null ? this.downloadOptions.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlaybackLanguage(code=" + this.code + ", name=" + this.name + ", playback=" + this.playback + ", downloadOptions=" + this.downloadOptions + ')';
    }

    public PlaybackLanguage(@JsonProperty("code") @Nullable String code, @JsonProperty("name") @Nullable String name, @JsonProperty("playback") @Nullable PlaybackStreams playback, @JsonProperty("download_options") @Nullable List<DownloadOption> list) {
        this.code = code;
        this.name = name;
        this.playback = playback;
        this.downloadOptions = list;
    }

    public /* synthetic */ PlaybackLanguage(String str, String str2, PlaybackStreams playbackStreams, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : playbackStreams, (i & 8) != 0 ? null : list);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final PlaybackStreams getPlayback() {
        return this.playback;
    }

    @Nullable
    public final List<DownloadOption> getDownloadOptions() {
        return this.downloadOptions;
    }
}
