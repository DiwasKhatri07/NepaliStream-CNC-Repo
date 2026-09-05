package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u009b\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u00060"}, d2 = {"Lcom/phisher98/ParsedFile;", "", "title", "", "year", "resolution", "quality", "encode", "releaseGroup", "seasonEpisode", "", "visualTags", "audioTags", "audioChannels", "languages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getYear", "getResolution", "getQuality", "getEncode", "getReleaseGroup", "getSeasonEpisode", "()Ljava/util/List;", "getVisualTags", "getAudioTags", "getAudioChannels", "getLanguages", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ParsedFile {

    @NotNull
    private final List<String> audioChannels;

    @NotNull
    private final List<String> audioTags;

    @Nullable
    private final String encode;

    @NotNull
    private final List<String> languages;

    @NotNull
    private final String quality;

    @Nullable
    private final String releaseGroup;

    @NotNull
    private final String resolution;

    @NotNull
    private final List<Object> seasonEpisode;

    @NotNull
    private final String title;

    @NotNull
    private final List<String> visualTags;

    @NotNull
    private final String year;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParsedFile copy$default(ParsedFile parsedFile, String str, String str2, String str3, String str4, String str5, String str6, List list, List list2, List list3, List list4, List list5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedFile.title;
        }
        if ((i & 2) != 0) {
            str2 = parsedFile.year;
        }
        if ((i & 4) != 0) {
            str3 = parsedFile.resolution;
        }
        if ((i & 8) != 0) {
            str4 = parsedFile.quality;
        }
        if ((i & 16) != 0) {
            str5 = parsedFile.encode;
        }
        if ((i & 32) != 0) {
            str6 = parsedFile.releaseGroup;
        }
        if ((i & 64) != 0) {
            list = parsedFile.seasonEpisode;
        }
        if ((i & 128) != 0) {
            list2 = parsedFile.visualTags;
        }
        if ((i & 256) != 0) {
            list3 = parsedFile.audioTags;
        }
        if ((i & 512) != 0) {
            list4 = parsedFile.audioChannels;
        }
        if ((i & 1024) != 0) {
            list5 = parsedFile.languages;
        }
        List list6 = list4;
        List list7 = list5;
        List list8 = list2;
        List list9 = list3;
        String str7 = str6;
        List list10 = list;
        String str8 = str5;
        String str9 = str3;
        return parsedFile.copy(str, str2, str9, str4, str8, str7, list10, list8, list9, list6, list7);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<String> component10() {
        return this.audioChannels;
    }

    @NotNull
    public final List<String> component11() {
        return this.languages;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getResolution() {
        return this.resolution;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEncode() {
        return this.encode;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReleaseGroup() {
        return this.releaseGroup;
    }

    @NotNull
    public final List<Object> component7() {
        return this.seasonEpisode;
    }

    @NotNull
    public final List<String> component8() {
        return this.visualTags;
    }

    @NotNull
    public final List<String> component9() {
        return this.audioTags;
    }

    @NotNull
    public final ParsedFile copy(@NotNull String title, @NotNull String year, @NotNull String resolution, @NotNull String quality, @Nullable String encode, @Nullable String releaseGroup, @NotNull List<? extends Object> seasonEpisode, @NotNull List<String> visualTags, @NotNull List<String> audioTags, @NotNull List<String> audioChannels, @NotNull List<String> languages) {
        return new ParsedFile(title, year, resolution, quality, encode, releaseGroup, seasonEpisode, visualTags, audioTags, audioChannels, languages);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedFile)) {
            return false;
        }
        ParsedFile parsedFile = (ParsedFile) other;
        return Intrinsics.areEqual(this.title, parsedFile.title) && Intrinsics.areEqual(this.year, parsedFile.year) && Intrinsics.areEqual(this.resolution, parsedFile.resolution) && Intrinsics.areEqual(this.quality, parsedFile.quality) && Intrinsics.areEqual(this.encode, parsedFile.encode) && Intrinsics.areEqual(this.releaseGroup, parsedFile.releaseGroup) && Intrinsics.areEqual(this.seasonEpisode, parsedFile.seasonEpisode) && Intrinsics.areEqual(this.visualTags, parsedFile.visualTags) && Intrinsics.areEqual(this.audioTags, parsedFile.audioTags) && Intrinsics.areEqual(this.audioChannels, parsedFile.audioChannels) && Intrinsics.areEqual(this.languages, parsedFile.languages);
    }

    public int hashCode() {
        return (((((((((((((((((((this.title.hashCode() * 31) + this.year.hashCode()) * 31) + this.resolution.hashCode()) * 31) + this.quality.hashCode()) * 31) + (this.encode == null ? 0 : this.encode.hashCode())) * 31) + (this.releaseGroup != null ? this.releaseGroup.hashCode() : 0)) * 31) + this.seasonEpisode.hashCode()) * 31) + this.visualTags.hashCode()) * 31) + this.audioTags.hashCode()) * 31) + this.audioChannels.hashCode()) * 31) + this.languages.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParsedFile(title=").append(this.title).append(", year=").append(this.year).append(", resolution=").append(this.resolution).append(", quality=").append(this.quality).append(", encode=").append(this.encode).append(", releaseGroup=").append(this.releaseGroup).append(", seasonEpisode=").append(this.seasonEpisode).append(", visualTags=").append(this.visualTags).append(", audioTags=").append(this.audioTags).append(", audioChannels=").append(this.audioChannels).append(", languages=").append(this.languages).append(')');
        return sb.toString();
    }

    public ParsedFile(@NotNull String title, @NotNull String year, @NotNull String resolution, @NotNull String quality, @Nullable String encode, @Nullable String releaseGroup, @NotNull List<? extends Object> list, @NotNull List<String> list2, @NotNull List<String> list3, @NotNull List<String> list4, @NotNull List<String> list5) {
        this.title = title;
        this.year = year;
        this.resolution = resolution;
        this.quality = quality;
        this.encode = encode;
        this.releaseGroup = releaseGroup;
        this.seasonEpisode = list;
        this.visualTags = list2;
        this.audioTags = list3;
        this.audioChannels = list4;
        this.languages = list5;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getYear() {
        return this.year;
    }

    @NotNull
    public final String getResolution() {
        return this.resolution;
    }

    @NotNull
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getEncode() {
        return this.encode;
    }

    @Nullable
    public final String getReleaseGroup() {
        return this.releaseGroup;
    }

    @NotNull
    public final List<Object> getSeasonEpisode() {
        return this.seasonEpisode;
    }

    @NotNull
    public final List<String> getVisualTags() {
        return this.visualTags;
    }

    @NotNull
    public final List<String> getAudioTags() {
        return this.audioTags;
    }

    @NotNull
    public final List<String> getAudioChannels() {
        return this.audioChannels;
    }

    @NotNull
    public final List<String> getLanguages() {
        return this.languages;
    }
}
