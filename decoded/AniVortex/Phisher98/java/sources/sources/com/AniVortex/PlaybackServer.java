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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u001e\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J}\u0010\u0018\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u001e\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR-\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R-\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/AniVortex/PlaybackServer;", "", "key", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "languages", "", "Lcom/AniVortex/PlaybackLanguage;", "subtitles", "Lcom/AniVortex/SubtitleInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getName", "getLanguages", "()Ljava/util/List;", "getSubtitles", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PlaybackServer {

    @JsonProperty("key")
    @Nullable
    private final String key;

    @JsonProperty("languages")
    @Nullable
    private final List<PlaybackLanguage> languages;

    @JsonProperty("name")
    @Nullable
    private final String name;

    @JsonProperty("subtitles")
    @Nullable
    private final List<SubtitleInfo> subtitles;

    public PlaybackServer() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaybackServer copy$default(PlaybackServer playbackServer, String str, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playbackServer.key;
        }
        if ((i & 2) != 0) {
            str2 = playbackServer.name;
        }
        if ((i & 4) != 0) {
            list = playbackServer.languages;
        }
        if ((i & 8) != 0) {
            list2 = playbackServer.subtitles;
        }
        return playbackServer.copy(str, str2, list, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<PlaybackLanguage> component3() {
        return this.languages;
    }

    @Nullable
    public final List<SubtitleInfo> component4() {
        return this.subtitles;
    }

    @NotNull
    public final PlaybackServer copy(@JsonProperty("key") @Nullable String key, @JsonProperty("name") @Nullable String name, @JsonProperty("languages") @Nullable List<PlaybackLanguage> languages, @JsonProperty("subtitles") @Nullable List<SubtitleInfo> subtitles) {
        return new PlaybackServer(key, name, languages, subtitles);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaybackServer)) {
            return false;
        }
        PlaybackServer playbackServer = (PlaybackServer) other;
        return Intrinsics.areEqual(this.key, playbackServer.key) && Intrinsics.areEqual(this.name, playbackServer.name) && Intrinsics.areEqual(this.languages, playbackServer.languages) && Intrinsics.areEqual(this.subtitles, playbackServer.subtitles);
    }

    public int hashCode() {
        return ((((((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.languages == null ? 0 : this.languages.hashCode())) * 31) + (this.subtitles != null ? this.subtitles.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlaybackServer(key=" + this.key + ", name=" + this.name + ", languages=" + this.languages + ", subtitles=" + this.subtitles + ')';
    }

    public PlaybackServer(@JsonProperty("key") @Nullable String key, @JsonProperty("name") @Nullable String name, @JsonProperty("languages") @Nullable List<PlaybackLanguage> list, @JsonProperty("subtitles") @Nullable List<SubtitleInfo> list2) {
        this.key = key;
        this.name = name;
        this.languages = list;
        this.subtitles = list2;
    }

    public /* synthetic */ PlaybackServer(String str, String str2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2);
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<PlaybackLanguage> getLanguages() {
        return this.languages;
    }

    @Nullable
    public final List<SubtitleInfo> getSubtitles() {
        return this.subtitles;
    }
}
