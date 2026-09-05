package com.Anichi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b)\bÆ\u0002\u0018\u00002\u00020\u0001:&\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006*"}, d2 = {"Lcom/Anichi/AnichiParser;", "", "<init>", "()V", "AnichiLoadData", "JikanData", "JikanResponse", "IdMal", "MediaAni", "DataAni", "CoverImage", "AniMedia", "Title", "AniPage", "AniData", "AniSearch", "AkIframe", "Stream", "PortData", "Subtitles", "Links", "Headers", "AnichiVideoApiResponse", "Data", "Shows", "EdgesCard", "CharacterImage", "CharacterName", "Characters", "Edges", "AvailableEpisodes", "AiredStart", "Season", "AnichiQuery", "Detail", "DetailShow", "AvailableEpisodesDetail", "LinksQuery", "LinkData", "Episode", "SourceUrls", "Downloads", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnichiParser {

    @NotNull
    public static final AnichiParser INSTANCE = new AnichiParser();

    private AnichiParser() {
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/Anichi/AnichiParser$AnichiLoadData;", "", "hash", "", "dubStatus", "episode", "idMal", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getHash", "()Ljava/lang/String;", "getDubStatus", "getEpisode", "getIdMal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/Anichi/AnichiParser$AnichiLoadData;", "equals", "", "other", "hashCode", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnichiLoadData {

        @NotNull
        private final String dubStatus;

        @NotNull
        private final String episode;

        @NotNull
        private final String hash;

        @Nullable
        private final Integer idMal;

        public static /* synthetic */ AnichiLoadData copy$default(AnichiLoadData anichiLoadData, String str, String str2, String str3, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = anichiLoadData.hash;
            }
            if ((i & 2) != 0) {
                str2 = anichiLoadData.dubStatus;
            }
            if ((i & 4) != 0) {
                str3 = anichiLoadData.episode;
            }
            if ((i & 8) != 0) {
                num = anichiLoadData.idMal;
            }
            return anichiLoadData.copy(str, str2, str3, num);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHash() {
            return this.hash;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDubStatus() {
            return this.dubStatus;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @NotNull
        public final AnichiLoadData copy(@NotNull String hash, @NotNull String dubStatus, @NotNull String episode, @Nullable Integer idMal) {
            return new AnichiLoadData(hash, dubStatus, episode, idMal);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnichiLoadData)) {
                return false;
            }
            AnichiLoadData anichiLoadData = (AnichiLoadData) other;
            return Intrinsics.areEqual(this.hash, anichiLoadData.hash) && Intrinsics.areEqual(this.dubStatus, anichiLoadData.dubStatus) && Intrinsics.areEqual(this.episode, anichiLoadData.episode) && Intrinsics.areEqual(this.idMal, anichiLoadData.idMal);
        }

        public int hashCode() {
            return (((((this.hash.hashCode() * 31) + this.dubStatus.hashCode()) * 31) + this.episode.hashCode()) * 31) + (this.idMal == null ? 0 : this.idMal.hashCode());
        }

        @NotNull
        public String toString() {
            return "AnichiLoadData(hash=" + this.hash + ", dubStatus=" + this.dubStatus + ", episode=" + this.episode + ", idMal=" + this.idMal + ')';
        }

        public AnichiLoadData(@NotNull String hash, @NotNull String dubStatus, @NotNull String episode, @Nullable Integer idMal) {
            this.hash = hash;
            this.dubStatus = dubStatus;
            this.episode = episode;
            this.idMal = idMal;
        }

        public /* synthetic */ AnichiLoadData(String str, String str2, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? null : num);
        }

        @NotNull
        public final String getHash() {
            return this.hash;
        }

        @NotNull
        public final String getDubStatus() {
            return this.dubStatus;
        }

        @NotNull
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jª\u0001\u0010\u001d\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\tHÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"}, d2 = {"Lcom/Anichi/AnichiParser$JikanData;", "", "title", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title_english", "title_japanese", "year", "", "season", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getTitle_english", "getTitle_japanese", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/Anichi/AnichiParser$JikanData;", "equals", "", "other", "hashCode", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class JikanData {

        @Nullable
        private final String season;

        @Nullable
        private final String title;

        @Nullable
        private final String title_english;

        @Nullable
        private final String title_japanese;

        @Nullable
        private final String type;

        @Nullable
        private final Integer year;

        public JikanData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ JikanData copy$default(JikanData jikanData, String str, String str2, String str3, Integer num, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jikanData.title;
            }
            if ((i & 2) != 0) {
                str2 = jikanData.title_english;
            }
            if ((i & 4) != 0) {
                str3 = jikanData.title_japanese;
            }
            if ((i & 8) != 0) {
                num = jikanData.year;
            }
            if ((i & 16) != 0) {
                str4 = jikanData.season;
            }
            if ((i & 32) != 0) {
                str5 = jikanData.type;
            }
            String str6 = str4;
            String str7 = str5;
            return jikanData.copy(str, str2, str3, num, str6, str7);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle_english() {
            return this.title_english;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle_japanese() {
            return this.title_japanese;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final JikanData copy(@JsonProperty("title") @Nullable String title, @JsonProperty("title_english") @Nullable String title_english, @JsonProperty("title_japanese") @Nullable String title_japanese, @JsonProperty("year") @Nullable Integer year, @JsonProperty("season") @Nullable String season, @JsonProperty("type") @Nullable String type) {
            return new JikanData(title, title_english, title_japanese, year, season, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JikanData)) {
                return false;
            }
            JikanData jikanData = (JikanData) other;
            return Intrinsics.areEqual(this.title, jikanData.title) && Intrinsics.areEqual(this.title_english, jikanData.title_english) && Intrinsics.areEqual(this.title_japanese, jikanData.title_japanese) && Intrinsics.areEqual(this.year, jikanData.year) && Intrinsics.areEqual(this.season, jikanData.season) && Intrinsics.areEqual(this.type, jikanData.type);
        }

        public int hashCode() {
            return ((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.title_english == null ? 0 : this.title_english.hashCode())) * 31) + (this.title_japanese == null ? 0 : this.title_japanese.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "JikanData(title=" + this.title + ", title_english=" + this.title_english + ", title_japanese=" + this.title_japanese + ", year=" + this.year + ", season=" + this.season + ", type=" + this.type + ')';
        }

        public JikanData(@JsonProperty("title") @Nullable String title, @JsonProperty("title_english") @Nullable String title_english, @JsonProperty("title_japanese") @Nullable String title_japanese, @JsonProperty("year") @Nullable Integer year, @JsonProperty("season") @Nullable String season, @JsonProperty("type") @Nullable String type) {
            this.title = title;
            this.title_english = title_english;
            this.title_japanese = title_japanese;
            this.year = year;
            this.season = season;
            this.type = type;
        }

        public /* synthetic */ JikanData(String str, String str2, String str3, Integer num, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTitle_english() {
            return this.title_english;
        }

        @Nullable
        public final String getTitle_japanese() {
            return this.title_japanese;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$JikanResponse;", "", "data", "Lcom/Anichi/AnichiParser$JikanData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$JikanData;)V", "getData", "()Lcom/Anichi/AnichiParser$JikanData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class JikanResponse {

        @Nullable
        private final JikanData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public JikanResponse() {
            JikanData jikanData = null;
            this(jikanData, 1, jikanData);
        }

        public static /* synthetic */ JikanResponse copy$default(JikanResponse jikanResponse, JikanData jikanData, int i, Object obj) {
            if ((i & 1) != 0) {
                jikanData = jikanResponse.data;
            }
            return jikanResponse.copy(jikanData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final JikanData getData() {
            return this.data;
        }

        @NotNull
        public final JikanResponse copy(@JsonProperty("data") @Nullable JikanData data) {
            return new JikanResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof JikanResponse) && Intrinsics.areEqual(this.data, ((JikanResponse) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "JikanResponse(data=" + this.data + ')';
        }

        public JikanResponse(@JsonProperty("data") @Nullable JikanData data) {
            this.data = data;
        }

        public /* synthetic */ JikanResponse(JikanData jikanData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : jikanData);
        }

        @Nullable
        public final JikanData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/Anichi/AnichiParser$IdMal;", "", "idMal", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getIdMal", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class IdMal {

        @Nullable
        private final String idMal;

        /* JADX WARN: Illegal instructions before constructor call */
        public IdMal() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ IdMal copy$default(IdMal idMal, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idMal.idMal;
            }
            return idMal.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIdMal() {
            return this.idMal;
        }

        @NotNull
        public final IdMal copy(@JsonProperty("idMal") @Nullable String idMal) {
            return new IdMal(idMal);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IdMal) && Intrinsics.areEqual(this.idMal, ((IdMal) other).idMal);
        }

        public int hashCode() {
            if (this.idMal == null) {
                return 0;
            }
            return this.idMal.hashCode();
        }

        @NotNull
        public String toString() {
            return "IdMal(idMal=" + this.idMal + ')';
        }

        public IdMal(@JsonProperty("idMal") @Nullable String idMal) {
            this.idMal = idMal;
        }

        public /* synthetic */ IdMal(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getIdMal() {
            return this.idMal;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/Anichi/AnichiParser$MediaAni;", "", "media", "Lcom/Anichi/AnichiParser$IdMal;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Media", "<init>", "(Lcom/Anichi/AnichiParser$IdMal;)V", "getMedia", "()Lcom/Anichi/AnichiParser$IdMal;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MediaAni {

        @Nullable
        private final IdMal media;

        /* JADX WARN: Illegal instructions before constructor call */
        public MediaAni() {
            IdMal idMal = null;
            this(idMal, 1, idMal);
        }

        public static /* synthetic */ MediaAni copy$default(MediaAni mediaAni, IdMal idMal, int i, Object obj) {
            if ((i & 1) != 0) {
                idMal = mediaAni.media;
            }
            return mediaAni.copy(idMal);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IdMal getMedia() {
            return this.media;
        }

        @NotNull
        public final MediaAni copy(@JsonProperty("Media") @Nullable IdMal media) {
            return new MediaAni(media);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MediaAni) && Intrinsics.areEqual(this.media, ((MediaAni) other).media);
        }

        public int hashCode() {
            if (this.media == null) {
                return 0;
            }
            return this.media.hashCode();
        }

        @NotNull
        public String toString() {
            return "MediaAni(media=" + this.media + ')';
        }

        public MediaAni(@JsonProperty("Media") @Nullable IdMal media) {
            this.media = media;
        }

        public /* synthetic */ MediaAni(IdMal idMal, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : idMal);
        }

        @Nullable
        public final IdMal getMedia() {
            return this.media;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$DataAni;", "", "data", "Lcom/Anichi/AnichiParser$MediaAni;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$MediaAni;)V", "getData", "()Lcom/Anichi/AnichiParser$MediaAni;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class DataAni {

        @Nullable
        private final MediaAni data;

        /* JADX WARN: Illegal instructions before constructor call */
        public DataAni() {
            MediaAni mediaAni = null;
            this(mediaAni, 1, mediaAni);
        }

        public static /* synthetic */ DataAni copy$default(DataAni dataAni, MediaAni mediaAni, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaAni = dataAni.data;
            }
            return dataAni.copy(mediaAni);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MediaAni getData() {
            return this.data;
        }

        @NotNull
        public final DataAni copy(@JsonProperty("data") @Nullable MediaAni data) {
            return new DataAni(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataAni) && Intrinsics.areEqual(this.data, ((DataAni) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "DataAni(data=" + this.data + ')';
        }

        public DataAni(@JsonProperty("data") @Nullable MediaAni data) {
            this.data = data;
        }

        public /* synthetic */ DataAni(MediaAni mediaAni, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : mediaAni);
        }

        @Nullable
        public final MediaAni getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/Anichi/AnichiParser$CoverImage;", "", "extraLarge", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "large", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getExtraLarge", "()Ljava/lang/String;", "setExtraLarge", "(Ljava/lang/String;)V", "getLarge", "setLarge", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CoverImage {

        @Nullable
        private String extraLarge;

        @Nullable
        private String large;

        /* JADX WARN: Illegal instructions before constructor call */
        public CoverImage() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ CoverImage copy$default(CoverImage coverImage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = coverImage.extraLarge;
            }
            if ((i & 2) != 0) {
                str2 = coverImage.large;
            }
            return coverImage.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getExtraLarge() {
            return this.extraLarge;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLarge() {
            return this.large;
        }

        @NotNull
        public final CoverImage copy(@JsonProperty("extraLarge") @Nullable String extraLarge, @JsonProperty("large") @Nullable String large) {
            return new CoverImage(extraLarge, large);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CoverImage)) {
                return false;
            }
            CoverImage coverImage = (CoverImage) other;
            return Intrinsics.areEqual(this.extraLarge, coverImage.extraLarge) && Intrinsics.areEqual(this.large, coverImage.large);
        }

        public int hashCode() {
            return ((this.extraLarge == null ? 0 : this.extraLarge.hashCode()) * 31) + (this.large != null ? this.large.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CoverImage(extraLarge=" + this.extraLarge + ", large=" + this.large + ')';
        }

        public CoverImage(@JsonProperty("extraLarge") @Nullable String extraLarge, @JsonProperty("large") @Nullable String large) {
            this.extraLarge = extraLarge;
            this.large = large;
        }

        public /* synthetic */ CoverImage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getExtraLarge() {
            return this.extraLarge;
        }

        public final void setExtraLarge(@Nullable String str) {
            this.extraLarge = str;
        }

        @Nullable
        public final String getLarge() {
            return this.large;
        }

        public final void setLarge(@Nullable String str) {
            this.large = str;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u001e\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003Jâ\u0001\u0010*\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u001e\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010HÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00100\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00061"}, d2 = {"Lcom/Anichi/AnichiParser$AniMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "idMal", "seasonYear", "format", "", "title", "Lcom/Anichi/AnichiParser$Title;", "synonyms", "", "coverImage", "Lcom/Anichi/AnichiParser$CoverImage;", "bannerImage", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/Anichi/AnichiParser$Title;Ljava/util/List;Lcom/Anichi/AnichiParser$CoverImage;Ljava/lang/String;)V", "getId", "()I", "getIdMal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeasonYear", "getFormat", "()Ljava/lang/String;", "getTitle", "()Lcom/Anichi/AnichiParser$Title;", "getSynonyms", "()Ljava/util/List;", "getCoverImage", "()Lcom/Anichi/AnichiParser$CoverImage;", "getBannerImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/Anichi/AnichiParser$Title;Ljava/util/List;Lcom/Anichi/AnichiParser$CoverImage;Ljava/lang/String;)Lcom/Anichi/AnichiParser$AniMedia;", "equals", "", "other", "hashCode", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniMedia {

        @Nullable
        private final String bannerImage;

        @Nullable
        private final CoverImage coverImage;

        @Nullable
        private final String format;
        private final int id;

        @Nullable
        private final Integer idMal;

        @Nullable
        private final Integer seasonYear;

        @Nullable
        private final List<String> synonyms;

        @Nullable
        private final Title title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniMedia copy$default(AniMedia aniMedia, int i, Integer num, Integer num2, String str, Title title, List list, CoverImage coverImage, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = aniMedia.id;
            }
            if ((i2 & 2) != 0) {
                num = aniMedia.idMal;
            }
            if ((i2 & 4) != 0) {
                num2 = aniMedia.seasonYear;
            }
            if ((i2 & 8) != 0) {
                str = aniMedia.format;
            }
            if ((i2 & 16) != 0) {
                title = aniMedia.title;
            }
            if ((i2 & 32) != 0) {
                list = aniMedia.synonyms;
            }
            if ((i2 & 64) != 0) {
                coverImage = aniMedia.coverImage;
            }
            if ((i2 & 128) != 0) {
                str2 = aniMedia.bannerImage;
            }
            CoverImage coverImage2 = coverImage;
            String str3 = str2;
            Title title2 = title;
            List list2 = list;
            return aniMedia.copy(i, num, num2, str, title2, list2, coverImage2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        public final List<String> component6() {
            return this.synonyms;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @NotNull
        public final AniMedia copy(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("seasonYear") @Nullable Integer seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("title") @Nullable Title title, @JsonProperty("synonyms") @Nullable List<String> synonyms, @JsonProperty("coverImage") @Nullable CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage) {
            return new AniMedia(id, idMal, seasonYear, format, title, synonyms, coverImage, bannerImage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniMedia)) {
                return false;
            }
            AniMedia aniMedia = (AniMedia) other;
            return this.id == aniMedia.id && Intrinsics.areEqual(this.idMal, aniMedia.idMal) && Intrinsics.areEqual(this.seasonYear, aniMedia.seasonYear) && Intrinsics.areEqual(this.format, aniMedia.format) && Intrinsics.areEqual(this.title, aniMedia.title) && Intrinsics.areEqual(this.synonyms, aniMedia.synonyms) && Intrinsics.areEqual(this.coverImage, aniMedia.coverImage) && Intrinsics.areEqual(this.bannerImage, aniMedia.bannerImage);
        }

        public int hashCode() {
            return (((((((((((((this.id * 31) + (this.idMal == null ? 0 : this.idMal.hashCode())) * 31) + (this.seasonYear == null ? 0 : this.seasonYear.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.synonyms == null ? 0 : this.synonyms.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.bannerImage != null ? this.bannerImage.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniMedia(id=" + this.id + ", idMal=" + this.idMal + ", seasonYear=" + this.seasonYear + ", format=" + this.format + ", title=" + this.title + ", synonyms=" + this.synonyms + ", coverImage=" + this.coverImage + ", bannerImage=" + this.bannerImage + ')';
        }

        public AniMedia(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("seasonYear") @Nullable Integer seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("title") @Nullable Title title, @JsonProperty("synonyms") @Nullable List<String> list, @JsonProperty("coverImage") @Nullable CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage) {
            this.id = id;
            this.idMal = idMal;
            this.seasonYear = seasonYear;
            this.format = format;
            this.title = title;
            this.synonyms = list;
            this.coverImage = coverImage;
            this.bannerImage = bannerImage;
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        public final Integer getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        @Nullable
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getBannerImage() {
            return this.bannerImage;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/Anichi/AnichiParser$Title;", "", "romaji", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "english", "native", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRomaji", "()Ljava/lang/String;", "getEnglish", "getNative", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Title {

        @Nullable
        private final String english;

        @Nullable
        private final String native;

        @Nullable
        private final String romaji;

        public static /* synthetic */ Title copy$default(Title title, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = title.romaji;
            }
            if ((i & 2) != 0) {
                str2 = title.english;
            }
            if ((i & 4) != 0) {
                str3 = title.native;
            }
            return title.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getNative() {
            return this.native;
        }

        @NotNull
        public final Title copy(@JsonProperty("romaji") @Nullable String romaji, @JsonProperty("english") @Nullable String english, @JsonProperty("native") @Nullable String str) {
            return new Title(romaji, english, str);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return Intrinsics.areEqual(this.romaji, title.romaji) && Intrinsics.areEqual(this.english, title.english) && Intrinsics.areEqual(this.native, title.native);
        }

        public int hashCode() {
            return ((((this.romaji == null ? 0 : this.romaji.hashCode()) * 31) + (this.english == null ? 0 : this.english.hashCode())) * 31) + (this.native != null ? this.native.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Title(romaji=" + this.romaji + ", english=" + this.english + ", native=" + this.native + ')';
        }

        public Title(@JsonProperty("romaji") @Nullable String romaji, @JsonProperty("english") @Nullable String english, @JsonProperty("native") @Nullable String str) {
            this.romaji = romaji;
            this.english = english;
            this.native = str;
        }

        @Nullable
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        public final String getNative() {
            return this.native;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/Anichi/AnichiParser$AniPage;", "", "media", "Ljava/util/ArrayList;", "Lcom/Anichi/AnichiParser$AniMedia;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getMedia", "()Ljava/util/ArrayList;", "setMedia", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniPage {

        @NotNull
        private ArrayList<AniMedia> media;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniPage() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniPage copy$default(AniPage aniPage, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = aniPage.media;
            }
            return aniPage.copy(arrayList);
        }

        @NotNull
        public final ArrayList<AniMedia> component1() {
            return this.media;
        }

        @NotNull
        public final AniPage copy(@JsonProperty("media") @NotNull ArrayList<AniMedia> media) {
            return new AniPage(media);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AniPage) && Intrinsics.areEqual(this.media, ((AniPage) other).media);
        }

        public int hashCode() {
            return this.media.hashCode();
        }

        @NotNull
        public String toString() {
            return "AniPage(media=" + this.media + ')';
        }

        public AniPage(@JsonProperty("media") @NotNull ArrayList<AniMedia> arrayList) {
            this.media = arrayList;
        }

        public /* synthetic */ AniPage(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @NotNull
        public final ArrayList<AniMedia> getMedia() {
            return this.media;
        }

        public final void setMedia(@NotNull ArrayList<AniMedia> arrayList) {
            this.media = arrayList;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/Anichi/AnichiParser$AniData;", "", "Page", "Lcom/Anichi/AnichiParser$AniPage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$AniPage;)V", "getPage", "()Lcom/Anichi/AnichiParser$AniPage;", "setPage", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniData {

        @Nullable
        private AniPage Page;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniData() {
            AniPage aniPage = null;
            this(aniPage, 1, aniPage);
        }

        public static /* synthetic */ AniData copy$default(AniData aniData, AniPage aniPage, int i, Object obj) {
            if ((i & 1) != 0) {
                aniPage = aniData.Page;
            }
            return aniData.copy(aniPage);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AniPage getPage() {
            return this.Page;
        }

        @NotNull
        public final AniData copy(@JsonProperty("Page") @Nullable AniPage Page) {
            return new AniData(Page);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AniData) && Intrinsics.areEqual(this.Page, ((AniData) other).Page);
        }

        public int hashCode() {
            if (this.Page == null) {
                return 0;
            }
            return this.Page.hashCode();
        }

        @NotNull
        public String toString() {
            return "AniData(Page=" + this.Page + ')';
        }

        public AniData(@JsonProperty("Page") @Nullable AniPage Page) {
            this.Page = Page;
        }

        public /* synthetic */ AniData(AniPage aniPage, int i, DefaultConstructorMarker defaultConstructorMarker) {
            int i2 = 1;
            if ((i & 1) != 0) {
                ArrayList arrayList = null;
                aniPage = new AniPage(arrayList, i2, arrayList);
            }
            this(aniPage);
        }

        @Nullable
        public final AniPage getPage() {
            return this.Page;
        }

        public final void setPage(@Nullable AniPage aniPage) {
            this.Page = aniPage;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/Anichi/AnichiParser$AniSearch;", "", "data", "Lcom/Anichi/AnichiParser$AniData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$AniData;)V", "getData", "()Lcom/Anichi/AnichiParser$AniData;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniSearch {

        @Nullable
        private AniData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniSearch() {
            AniData aniData = null;
            this(aniData, 1, aniData);
        }

        public static /* synthetic */ AniSearch copy$default(AniSearch aniSearch, AniData aniData, int i, Object obj) {
            if ((i & 1) != 0) {
                aniData = aniSearch.data;
            }
            return aniSearch.copy(aniData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AniData getData() {
            return this.data;
        }

        @NotNull
        public final AniSearch copy(@JsonProperty("data") @Nullable AniData data) {
            return new AniSearch(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AniSearch) && Intrinsics.areEqual(this.data, ((AniSearch) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AniSearch(data=" + this.data + ')';
        }

        public AniSearch(@JsonProperty("data") @Nullable AniData data) {
            this.data = data;
        }

        public /* synthetic */ AniSearch(AniData aniData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            int i2 = 1;
            if ((i & 1) != 0) {
                AniPage aniPage = null;
                aniData = new AniData(aniPage, i2, aniPage);
            }
            this(aniData);
        }

        @Nullable
        public final AniData getData() {
            return this.data;
        }

        public final void setData(@Nullable AniData aniData) {
            this.data = aniData;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/Anichi/AnichiParser$AkIframe;", "", "idUrl", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getIdUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AkIframe {

        @Nullable
        private final String idUrl;

        /* JADX WARN: Illegal instructions before constructor call */
        public AkIframe() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ AkIframe copy$default(AkIframe akIframe, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = akIframe.idUrl;
            }
            return akIframe.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIdUrl() {
            return this.idUrl;
        }

        @NotNull
        public final AkIframe copy(@JsonProperty("idUrl") @Nullable String idUrl) {
            return new AkIframe(idUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AkIframe) && Intrinsics.areEqual(this.idUrl, ((AkIframe) other).idUrl);
        }

        public int hashCode() {
            if (this.idUrl == null) {
                return 0;
            }
            return this.idUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "AkIframe(idUrl=" + this.idUrl + ')';
        }

        public AkIframe(@JsonProperty("idUrl") @Nullable String idUrl) {
            this.idUrl = idUrl;
        }

        public /* synthetic */ AkIframe(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getIdUrl() {
            return this.idUrl;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/Anichi/AnichiParser$Stream;", "", "format", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "audio_lang", "hardsub_lang", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFormat", "()Ljava/lang/String;", "getAudio_lang", "getHardsub_lang", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Stream {

        @Nullable
        private final String audio_lang;

        @Nullable
        private final String format;

        @Nullable
        private final String hardsub_lang;

        @Nullable
        private final String url;

        public Stream() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Stream copy$default(Stream stream, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stream.format;
            }
            if ((i & 2) != 0) {
                str2 = stream.audio_lang;
            }
            if ((i & 4) != 0) {
                str3 = stream.hardsub_lang;
            }
            if ((i & 8) != 0) {
                str4 = stream.url;
            }
            return stream.copy(str, str2, str3, str4);
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
        public final Stream copy(@JsonProperty("format") @Nullable String format, @JsonProperty("audio_lang") @Nullable String audio_lang, @JsonProperty("hardsub_lang") @Nullable String hardsub_lang, @JsonProperty("url") @Nullable String url) {
            return new Stream(format, audio_lang, hardsub_lang, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stream)) {
                return false;
            }
            Stream stream = (Stream) other;
            return Intrinsics.areEqual(this.format, stream.format) && Intrinsics.areEqual(this.audio_lang, stream.audio_lang) && Intrinsics.areEqual(this.hardsub_lang, stream.hardsub_lang) && Intrinsics.areEqual(this.url, stream.url);
        }

        public int hashCode() {
            return ((((((this.format == null ? 0 : this.format.hashCode()) * 31) + (this.audio_lang == null ? 0 : this.audio_lang.hashCode())) * 31) + (this.hardsub_lang == null ? 0 : this.hardsub_lang.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Stream(format=" + this.format + ", audio_lang=" + this.audio_lang + ", hardsub_lang=" + this.hardsub_lang + ", url=" + this.url + ')';
        }

        public Stream(@JsonProperty("format") @Nullable String format, @JsonProperty("audio_lang") @Nullable String audio_lang, @JsonProperty("hardsub_lang") @Nullable String hardsub_lang, @JsonProperty("url") @Nullable String url) {
            this.format = format;
            this.audio_lang = audio_lang;
            this.hardsub_lang = hardsub_lang;
            this.url = url;
        }

        public /* synthetic */ Stream(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/Anichi/AnichiParser$PortData;", "", "streams", "Ljava/util/ArrayList;", "Lcom/Anichi/AnichiParser$Stream;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getStreams", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PortData {

        @Nullable
        private final ArrayList<Stream> streams;

        /* JADX WARN: Illegal instructions before constructor call */
        public PortData() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PortData copy$default(PortData portData, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = portData.streams;
            }
            return portData.copy(arrayList);
        }

        @Nullable
        public final ArrayList<Stream> component1() {
            return this.streams;
        }

        @NotNull
        public final PortData copy(@JsonProperty("streams") @Nullable ArrayList<Stream> streams) {
            return new PortData(streams);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PortData) && Intrinsics.areEqual(this.streams, ((PortData) other).streams);
        }

        public int hashCode() {
            if (this.streams == null) {
                return 0;
            }
            return this.streams.hashCode();
        }

        @NotNull
        public String toString() {
            return "PortData(streams=" + this.streams + ')';
        }

        public PortData(@JsonProperty("streams") @Nullable ArrayList<Stream> arrayList) {
            this.streams = arrayList;
        }

        public /* synthetic */ PortData(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<Stream> getStreams() {
            return this.streams;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/Anichi/AnichiParser$Subtitles;", "", "lang", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "label", "src", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getLabel", "getSrc", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Subtitles {

        @Nullable
        private final String label;

        @Nullable
        private final String lang;

        @Nullable
        private final String src;

        public static /* synthetic */ Subtitles copy$default(Subtitles subtitles, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitles.lang;
            }
            if ((i & 2) != 0) {
                str2 = subtitles.label;
            }
            if ((i & 4) != 0) {
                str3 = subtitles.src;
            }
            return subtitles.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSrc() {
            return this.src;
        }

        @NotNull
        public final Subtitles copy(@JsonProperty("lang") @Nullable String lang, @JsonProperty("label") @Nullable String label, @JsonProperty("src") @Nullable String src) {
            return new Subtitles(lang, label, src);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitles)) {
                return false;
            }
            Subtitles subtitles = (Subtitles) other;
            return Intrinsics.areEqual(this.lang, subtitles.lang) && Intrinsics.areEqual(this.label, subtitles.label) && Intrinsics.areEqual(this.src, subtitles.src);
        }

        public int hashCode() {
            return ((((this.lang == null ? 0 : this.lang.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.src != null ? this.src.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Subtitles(lang=" + this.lang + ", label=" + this.label + ", src=" + this.src + ')';
        }

        public Subtitles(@JsonProperty("lang") @Nullable String lang, @JsonProperty("label") @Nullable String label, @JsonProperty("src") @Nullable String src) {
            this.lang = lang;
            this.label = label;
            this.src = src;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getSrc() {
            return this.src;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012*\b\u0003\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\u001d\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011HÆ\u0003JÒ\u0001\u0010(\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2*\b\u0003\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0014\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR%\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/Anichi/AnichiParser$Links;", "", "link", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "hls", "", "resolutionStr", "src", "headers", "Lcom/Anichi/AnichiParser$Headers;", "portData", "Lcom/Anichi/AnichiParser$PortData;", "subtitles", "Ljava/util/ArrayList;", "Lcom/Anichi/AnichiParser$Subtitles;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/Anichi/AnichiParser$Headers;Lcom/Anichi/AnichiParser$PortData;Ljava/util/ArrayList;)V", "getLink", "()Ljava/lang/String;", "getHls", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResolutionStr", "getSrc", "getHeaders", "()Lcom/Anichi/AnichiParser$Headers;", "getPortData", "()Lcom/Anichi/AnichiParser$PortData;", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/Anichi/AnichiParser$Headers;Lcom/Anichi/AnichiParser$PortData;Ljava/util/ArrayList;)Lcom/Anichi/AnichiParser$Links;", "equals", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Links {

        @Nullable
        private final Headers headers;

        @Nullable
        private final Boolean hls;

        @NotNull
        private final String link;

        @Nullable
        private final PortData portData;

        @NotNull
        private final String resolutionStr;

        @Nullable
        private final String src;

        @Nullable
        private final ArrayList<Subtitles> subtitles;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Links copy$default(Links links, String str, Boolean bool, String str2, String str3, Headers headers, PortData portData, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = links.link;
            }
            if ((i & 2) != 0) {
                bool = links.hls;
            }
            if ((i & 4) != 0) {
                str2 = links.resolutionStr;
            }
            if ((i & 8) != 0) {
                str3 = links.src;
            }
            if ((i & 16) != 0) {
                headers = links.headers;
            }
            if ((i & 32) != 0) {
                portData = links.portData;
            }
            if ((i & 64) != 0) {
                arrayList = links.subtitles;
            }
            PortData portData2 = portData;
            ArrayList arrayList2 = arrayList;
            Headers headers2 = headers;
            String str4 = str2;
            return links.copy(str, bool, str4, str3, headers2, portData2, arrayList2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getHls() {
            return this.hls;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getResolutionStr() {
            return this.resolutionStr;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSrc() {
            return this.src;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Headers getHeaders() {
            return this.headers;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final PortData getPortData() {
            return this.portData;
        }

        @Nullable
        public final ArrayList<Subtitles> component7() {
            return this.subtitles;
        }

        @NotNull
        public final Links copy(@JsonProperty("link") @NotNull String link, @JsonProperty("hls") @Nullable Boolean hls, @JsonProperty("resolutionStr") @NotNull String resolutionStr, @JsonProperty("src") @Nullable String src, @JsonProperty("headers") @Nullable Headers headers, @JsonProperty("portData") @Nullable PortData portData, @JsonProperty("subtitles") @Nullable ArrayList<Subtitles> subtitles) {
            return new Links(link, hls, resolutionStr, src, headers, portData, subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Links)) {
                return false;
            }
            Links links = (Links) other;
            return Intrinsics.areEqual(this.link, links.link) && Intrinsics.areEqual(this.hls, links.hls) && Intrinsics.areEqual(this.resolutionStr, links.resolutionStr) && Intrinsics.areEqual(this.src, links.src) && Intrinsics.areEqual(this.headers, links.headers) && Intrinsics.areEqual(this.portData, links.portData) && Intrinsics.areEqual(this.subtitles, links.subtitles);
        }

        public int hashCode() {
            return (((((((((((this.link.hashCode() * 31) + (this.hls == null ? 0 : this.hls.hashCode())) * 31) + this.resolutionStr.hashCode()) * 31) + (this.src == null ? 0 : this.src.hashCode())) * 31) + (this.headers == null ? 0 : this.headers.hashCode())) * 31) + (this.portData == null ? 0 : this.portData.hashCode())) * 31) + (this.subtitles != null ? this.subtitles.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Links(link=" + this.link + ", hls=" + this.hls + ", resolutionStr=" + this.resolutionStr + ", src=" + this.src + ", headers=" + this.headers + ", portData=" + this.portData + ", subtitles=" + this.subtitles + ')';
        }

        public Links(@JsonProperty("link") @NotNull String link, @JsonProperty("hls") @Nullable Boolean hls, @JsonProperty("resolutionStr") @NotNull String resolutionStr, @JsonProperty("src") @Nullable String src, @JsonProperty("headers") @Nullable Headers headers, @JsonProperty("portData") @Nullable PortData portData, @JsonProperty("subtitles") @Nullable ArrayList<Subtitles> arrayList) {
            this.link = link;
            this.hls = hls;
            this.resolutionStr = resolutionStr;
            this.src = src;
            this.headers = headers;
            this.portData = portData;
            this.subtitles = arrayList;
        }

        public /* synthetic */ Links(String str, Boolean bool, String str2, String str3, Headers headers, PortData portData, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : bool, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : headers, (i & 32) != 0 ? null : portData, (i & 64) != 0 ? new ArrayList() : arrayList);
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final Boolean getHls() {
            return this.hls;
        }

        @NotNull
        public final String getResolutionStr() {
            return this.resolutionStr;
        }

        @Nullable
        public final String getSrc() {
            return this.src;
        }

        @Nullable
        public final Headers getHeaders() {
            return this.headers;
        }

        @Nullable
        public final PortData getPortData() {
            return this.portData;
        }

        @Nullable
        public final ArrayList<Subtitles> getSubtitles() {
            return this.subtitles;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/Anichi/AnichiParser$Headers;", "", "referer", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Referer", "origin", "Origin", "userAgent", "user-agent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getReferer", "()Ljava/lang/String;", "getOrigin", "getUserAgent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Headers {

        @Nullable
        private final String origin;

        @Nullable
        private final String referer;

        @Nullable
        private final String userAgent;

        public Headers() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Headers copy$default(Headers headers, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = headers.referer;
            }
            if ((i & 2) != 0) {
                str2 = headers.origin;
            }
            if ((i & 4) != 0) {
                str3 = headers.userAgent;
            }
            return headers.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getReferer() {
            return this.referer;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOrigin() {
            return this.origin;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUserAgent() {
            return this.userAgent;
        }

        @NotNull
        public final Headers copy(@JsonProperty("Referer") @Nullable String referer, @JsonProperty("Origin") @Nullable String origin, @JsonProperty("user-agent") @Nullable String userAgent) {
            return new Headers(referer, origin, userAgent);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Headers)) {
                return false;
            }
            Headers headers = (Headers) other;
            return Intrinsics.areEqual(this.referer, headers.referer) && Intrinsics.areEqual(this.origin, headers.origin) && Intrinsics.areEqual(this.userAgent, headers.userAgent);
        }

        public int hashCode() {
            return ((((this.referer == null ? 0 : this.referer.hashCode()) * 31) + (this.origin == null ? 0 : this.origin.hashCode())) * 31) + (this.userAgent != null ? this.userAgent.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Headers(referer=" + this.referer + ", origin=" + this.origin + ", userAgent=" + this.userAgent + ')';
        }

        public Headers(@JsonProperty("Referer") @Nullable String referer, @JsonProperty("Origin") @Nullable String origin, @JsonProperty("user-agent") @Nullable String userAgent) {
            this.referer = referer;
            this.origin = origin;
            this.userAgent = userAgent;
        }

        public /* synthetic */ Headers(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getReferer() {
            return this.referer;
        }

        @Nullable
        public final String getOrigin() {
            return this.origin;
        }

        @Nullable
        public final String getUserAgent() {
            return this.userAgent;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/Anichi/AnichiParser$AnichiVideoApiResponse;", "", "links", "", "Lcom/Anichi/AnichiParser$Links;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getLinks", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnichiVideoApiResponse {

        @NotNull
        private final List<Links> links;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnichiVideoApiResponse copy$default(AnichiVideoApiResponse anichiVideoApiResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = anichiVideoApiResponse.links;
            }
            return anichiVideoApiResponse.copy(list);
        }

        @NotNull
        public final List<Links> component1() {
            return this.links;
        }

        @NotNull
        public final AnichiVideoApiResponse copy(@JsonProperty("links") @NotNull List<Links> links) {
            return new AnichiVideoApiResponse(links);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnichiVideoApiResponse) && Intrinsics.areEqual(this.links, ((AnichiVideoApiResponse) other).links);
        }

        public int hashCode() {
            return this.links.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnichiVideoApiResponse(links=" + this.links + ')';
        }

        public AnichiVideoApiResponse(@JsonProperty("links") @NotNull List<Links> list) {
            this.links = list;
        }

        @NotNull
        public final List<Links> getLinks() {
            return this.links;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/Anichi/AnichiParser$Data;", "", "shows", "Lcom/Anichi/AnichiParser$Shows;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "queryListForTag", "queryPopular", "<init>", "(Lcom/Anichi/AnichiParser$Shows;Lcom/Anichi/AnichiParser$Shows;Lcom/Anichi/AnichiParser$Shows;)V", "getShows", "()Lcom/Anichi/AnichiParser$Shows;", "getQueryListForTag", "getQueryPopular", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Data {

        @Nullable
        private final Shows queryListForTag;

        @Nullable
        private final Shows queryPopular;

        @Nullable
        private final Shows shows;

        public Data() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Data copy$default(Data data, Shows shows, Shows shows2, Shows shows3, int i, Object obj) {
            if ((i & 1) != 0) {
                shows = data.shows;
            }
            if ((i & 2) != 0) {
                shows2 = data.queryListForTag;
            }
            if ((i & 4) != 0) {
                shows3 = data.queryPopular;
            }
            return data.copy(shows, shows2, shows3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Shows getShows() {
            return this.shows;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Shows getQueryListForTag() {
            return this.queryListForTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Shows getQueryPopular() {
            return this.queryPopular;
        }

        @NotNull
        public final Data copy(@JsonProperty("shows") @Nullable Shows shows, @JsonProperty("queryListForTag") @Nullable Shows queryListForTag, @JsonProperty("queryPopular") @Nullable Shows queryPopular) {
            return new Data(shows, queryListForTag, queryPopular);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.shows, data.shows) && Intrinsics.areEqual(this.queryListForTag, data.queryListForTag) && Intrinsics.areEqual(this.queryPopular, data.queryPopular);
        }

        public int hashCode() {
            return ((((this.shows == null ? 0 : this.shows.hashCode()) * 31) + (this.queryListForTag == null ? 0 : this.queryListForTag.hashCode())) * 31) + (this.queryPopular != null ? this.queryPopular.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Data(shows=" + this.shows + ", queryListForTag=" + this.queryListForTag + ", queryPopular=" + this.queryPopular + ')';
        }

        public Data(@JsonProperty("shows") @Nullable Shows shows, @JsonProperty("queryListForTag") @Nullable Shows queryListForTag, @JsonProperty("queryPopular") @Nullable Shows queryPopular) {
            this.shows = shows;
            this.queryListForTag = queryListForTag;
            this.queryPopular = queryPopular;
        }

        public /* synthetic */ Data(Shows shows, Shows shows2, Shows shows3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : shows, (i & 2) != 0 ? null : shows2, (i & 4) != 0 ? null : shows3);
        }

        @Nullable
        public final Shows getShows() {
            return this.shows;
        }

        @Nullable
        public final Shows getQueryListForTag() {
            return this.queryListForTag;
        }

        @Nullable
        public final Shows getQueryPopular() {
            return this.queryPopular;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003JI\u0010\u0010\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/Anichi/AnichiParser$Shows;", "", "edges", "", "Lcom/Anichi/AnichiParser$Edges;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "recommendations", "Lcom/Anichi/AnichiParser$EdgesCard;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "getRecommendations", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Shows {

        @Nullable
        private final List<Edges> edges;

        @Nullable
        private final List<EdgesCard> recommendations;

        /* JADX WARN: Illegal instructions before constructor call */
        public Shows() {
            List list = null;
            this(list, list, 3, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Shows copy$default(Shows shows, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = shows.edges;
            }
            if ((i & 2) != 0) {
                list2 = shows.recommendations;
            }
            return shows.copy(list, list2);
        }

        @Nullable
        public final List<Edges> component1() {
            return this.edges;
        }

        @Nullable
        public final List<EdgesCard> component2() {
            return this.recommendations;
        }

        @NotNull
        public final Shows copy(@JsonProperty("edges") @Nullable List<Edges> edges, @JsonProperty("recommendations") @Nullable List<EdgesCard> recommendations) {
            return new Shows(edges, recommendations);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Shows)) {
                return false;
            }
            Shows shows = (Shows) other;
            return Intrinsics.areEqual(this.edges, shows.edges) && Intrinsics.areEqual(this.recommendations, shows.recommendations);
        }

        public int hashCode() {
            return ((this.edges == null ? 0 : this.edges.hashCode()) * 31) + (this.recommendations != null ? this.recommendations.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Shows(edges=" + this.edges + ", recommendations=" + this.recommendations + ')';
        }

        public Shows(@JsonProperty("edges") @Nullable List<Edges> list, @JsonProperty("recommendations") @Nullable List<EdgesCard> list2) {
            this.edges = list;
            this.recommendations = list2;
        }

        public /* synthetic */ Shows(ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2);
        }

        @Nullable
        public final List<Edges> getEdges() {
            return this.edges;
        }

        @Nullable
        public final List<EdgesCard> getRecommendations() {
            return this.recommendations;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$EdgesCard;", "", "anyCard", "Lcom/Anichi/AnichiParser$Edges;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$Edges;)V", "getAnyCard", "()Lcom/Anichi/AnichiParser$Edges;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EdgesCard {

        @Nullable
        private final Edges anyCard;

        /* JADX WARN: Illegal instructions before constructor call */
        public EdgesCard() {
            Edges edges = null;
            this(edges, 1, edges);
        }

        public static /* synthetic */ EdgesCard copy$default(EdgesCard edgesCard, Edges edges, int i, Object obj) {
            if ((i & 1) != 0) {
                edges = edgesCard.anyCard;
            }
            return edgesCard.copy(edges);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Edges getAnyCard() {
            return this.anyCard;
        }

        @NotNull
        public final EdgesCard copy(@JsonProperty("anyCard") @Nullable Edges anyCard) {
            return new EdgesCard(anyCard);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EdgesCard) && Intrinsics.areEqual(this.anyCard, ((EdgesCard) other).anyCard);
        }

        public int hashCode() {
            if (this.anyCard == null) {
                return 0;
            }
            return this.anyCard.hashCode();
        }

        @NotNull
        public String toString() {
            return "EdgesCard(anyCard=" + this.anyCard + ')';
        }

        public EdgesCard(@JsonProperty("anyCard") @Nullable Edges anyCard) {
            this.anyCard = anyCard;
        }

        public /* synthetic */ EdgesCard(Edges edges, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : edges);
        }

        @Nullable
        public final Edges getAnyCard() {
            return this.anyCard;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/Anichi/AnichiParser$CharacterImage;", "", "large", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "medium", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getMedium", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CharacterImage {

        @Nullable
        private final String large;

        @Nullable
        private final String medium;

        public static /* synthetic */ CharacterImage copy$default(CharacterImage characterImage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = characterImage.large;
            }
            if ((i & 2) != 0) {
                str2 = characterImage.medium;
            }
            return characterImage.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMedium() {
            return this.medium;
        }

        @NotNull
        public final CharacterImage copy(@JsonProperty("large") @Nullable String large, @JsonProperty("medium") @Nullable String medium) {
            return new CharacterImage(large, medium);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CharacterImage)) {
                return false;
            }
            CharacterImage characterImage = (CharacterImage) other;
            return Intrinsics.areEqual(this.large, characterImage.large) && Intrinsics.areEqual(this.medium, characterImage.medium);
        }

        public int hashCode() {
            return ((this.large == null ? 0 : this.large.hashCode()) * 31) + (this.medium != null ? this.medium.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CharacterImage(large=" + this.large + ", medium=" + this.medium + ')';
        }

        public CharacterImage(@JsonProperty("large") @Nullable String large, @JsonProperty("medium") @Nullable String medium) {
            this.large = large;
            this.medium = medium;
        }

        @Nullable
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        public final String getMedium() {
            return this.medium;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/Anichi/AnichiParser$CharacterName;", "", "full", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "native", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFull", "()Ljava/lang/String;", "getNative", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CharacterName {

        @Nullable
        private final String full;

        @Nullable
        private final String native;

        public static /* synthetic */ CharacterName copy$default(CharacterName characterName, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = characterName.full;
            }
            if ((i & 2) != 0) {
                str2 = characterName.native;
            }
            return characterName.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFull() {
            return this.full;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNative() {
            return this.native;
        }

        @NotNull
        public final CharacterName copy(@JsonProperty("full") @Nullable String full, @JsonProperty("native") @Nullable String str) {
            return new CharacterName(full, str);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CharacterName)) {
                return false;
            }
            CharacterName characterName = (CharacterName) other;
            return Intrinsics.areEqual(this.full, characterName.full) && Intrinsics.areEqual(this.native, characterName.native);
        }

        public int hashCode() {
            return ((this.full == null ? 0 : this.full.hashCode()) * 31) + (this.native != null ? this.native.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CharacterName(full=" + this.full + ", native=" + this.native + ')';
        }

        public CharacterName(@JsonProperty("full") @Nullable String full, @JsonProperty("native") @Nullable String str) {
            this.full = full;
            this.native = str;
        }

        @Nullable
        public final String getFull() {
            return this.full;
        }

        @Nullable
        public final String getNative() {
            return this.native;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003JW\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/Anichi/AnichiParser$Characters;", "", "image", "Lcom/Anichi/AnichiParser$CharacterImage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "role", "", "name", "Lcom/Anichi/AnichiParser$CharacterName;", "<init>", "(Lcom/Anichi/AnichiParser$CharacterImage;Ljava/lang/String;Lcom/Anichi/AnichiParser$CharacterName;)V", "getImage", "()Lcom/Anichi/AnichiParser$CharacterImage;", "getRole", "()Ljava/lang/String;", "getName", "()Lcom/Anichi/AnichiParser$CharacterName;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Characters {

        @Nullable
        private final CharacterImage image;

        @Nullable
        private final CharacterName name;

        @Nullable
        private final String role;

        public static /* synthetic */ Characters copy$default(Characters characters, CharacterImage characterImage, String str, CharacterName characterName, int i, Object obj) {
            if ((i & 1) != 0) {
                characterImage = characters.image;
            }
            if ((i & 2) != 0) {
                str = characters.role;
            }
            if ((i & 4) != 0) {
                characterName = characters.name;
            }
            return characters.copy(characterImage, str, characterName);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharacterImage getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRole() {
            return this.role;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharacterName getName() {
            return this.name;
        }

        @NotNull
        public final Characters copy(@JsonProperty("image") @Nullable CharacterImage image, @JsonProperty("role") @Nullable String role, @JsonProperty("name") @Nullable CharacterName name) {
            return new Characters(image, role, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Characters)) {
                return false;
            }
            Characters characters = (Characters) other;
            return Intrinsics.areEqual(this.image, characters.image) && Intrinsics.areEqual(this.role, characters.role) && Intrinsics.areEqual(this.name, characters.name);
        }

        public int hashCode() {
            return ((((this.image == null ? 0 : this.image.hashCode()) * 31) + (this.role == null ? 0 : this.role.hashCode())) * 31) + (this.name != null ? this.name.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Characters(image=" + this.image + ", role=" + this.role + ", name=" + this.name + ')';
        }

        public Characters(@JsonProperty("image") @Nullable CharacterImage image, @JsonProperty("role") @Nullable String role, @JsonProperty("name") @Nullable CharacterName name) {
            this.image = image;
            this.role = role;
            this.name = name;
        }

        @Nullable
        public final CharacterImage getImage() {
            return this.image;
        }

        @Nullable
        public final String getRole() {
            return this.role;
        }

        @Nullable
        public final CharacterName getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0004\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u001e\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u001e\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u001e\b\u0001\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u001e\b\u0001\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0018\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e\u0012\u0018\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0018\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0018\b\u0001\u0010!\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!\u0012\u001c\b\u0003\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"¢\u0006\u0004\b#\u0010$J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010L\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017HÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010;J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017HÆ\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010;J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0003JÌ\u0004\u0010Y\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u001e\b\u0003\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u001e\b\u0003\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u001e\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u001e\b\u0003\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0018\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e2\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f2\u0018\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( 2\u0018\b\u0003\u0010!\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(!2\u001c\b\u0003\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"HÆ\u0001¢\u0006\u0002\u0010ZJ\u0014\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010^\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010_\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b>\u00108R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010&R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010&R\u0015\u0010!\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010<\u001a\u0004\bB\u0010;R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\b\n\u0000\u001a\u0004\bC\u00108¨\u0006`"}, d2 = {"Lcom/Anichi/AnichiParser$Edges;", "", "Id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "name", "englishName", "nativeName", "thumbnail", "type", "season", "Lcom/Anichi/AnichiParser$Season;", "score", "", "airedStart", "Lcom/Anichi/AnichiParser$AiredStart;", "availableEpisodes", "Lcom/Anichi/AnichiParser$AvailableEpisodes;", "availableEpisodesDetail", "Lcom/Anichi/AnichiParser$AvailableEpisodesDetail;", "studios", "", "genres", "averageScore", "", "characters", "Lcom/Anichi/AnichiParser$Characters;", "altNames", "description", "status", "banner", "episodeDuration", "prevideos", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/Anichi/AnichiParser$Season;Ljava/lang/Double;Lcom/Anichi/AnichiParser$AiredStart;Lcom/Anichi/AnichiParser$AvailableEpisodes;Lcom/Anichi/AnichiParser$AvailableEpisodesDetail;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "getEnglishName", "getNativeName", "getThumbnail", "getType", "getSeason", "()Lcom/Anichi/AnichiParser$Season;", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAiredStart", "()Lcom/Anichi/AnichiParser$AiredStart;", "getAvailableEpisodes", "()Lcom/Anichi/AnichiParser$AvailableEpisodes;", "getAvailableEpisodesDetail", "()Lcom/Anichi/AnichiParser$AvailableEpisodesDetail;", "getStudios", "()Ljava/util/List;", "getGenres", "getAverageScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCharacters", "getAltNames", "getDescription", "getStatus", "getBanner", "getEpisodeDuration", "getPrevideos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/Anichi/AnichiParser$Season;Ljava/lang/Double;Lcom/Anichi/AnichiParser$AiredStart;Lcom/Anichi/AnichiParser$AvailableEpisodes;Lcom/Anichi/AnichiParser$AvailableEpisodesDetail;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/Anichi/AnichiParser$Edges;", "equals", "", "other", "hashCode", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Edges {

        @Nullable
        private final String Id;

        @Nullable
        private final AiredStart airedStart;

        @Nullable
        private final List<String> altNames;

        @Nullable
        private final AvailableEpisodes availableEpisodes;

        @Nullable
        private final AvailableEpisodesDetail availableEpisodesDetail;

        @Nullable
        private final Integer averageScore;

        @Nullable
        private final String banner;

        @Nullable
        private final List<Characters> characters;

        @Nullable
        private final String description;

        @Nullable
        private final String englishName;

        @Nullable
        private final Integer episodeDuration;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final String name;

        @Nullable
        private final String nativeName;

        @NotNull
        private final List<String> prevideos;

        @Nullable
        private final Double score;

        @Nullable
        private final Season season;

        @Nullable
        private final String status;

        @Nullable
        private final List<String> studios;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Edges copy$default(Edges edges, String str, String str2, String str3, String str4, String str5, String str6, Season season, Double d, AiredStart airedStart, AvailableEpisodes availableEpisodes, AvailableEpisodesDetail availableEpisodesDetail, List list, List list2, Integer num, List list3, List list4, String str7, String str8, String str9, Integer num2, List list5, int i, Object obj) {
            List list6;
            Integer num3;
            String str10 = (i & 1) != 0 ? edges.Id : str;
            String str11 = (i & 2) != 0 ? edges.name : str2;
            String str12 = (i & 4) != 0 ? edges.englishName : str3;
            String str13 = (i & 8) != 0 ? edges.nativeName : str4;
            String str14 = (i & 16) != 0 ? edges.thumbnail : str5;
            String str15 = (i & 32) != 0 ? edges.type : str6;
            Season season2 = (i & 64) != 0 ? edges.season : season;
            Double d2 = (i & 128) != 0 ? edges.score : d;
            AiredStart airedStart2 = (i & 256) != 0 ? edges.airedStart : airedStart;
            AvailableEpisodes availableEpisodes2 = (i & 512) != 0 ? edges.availableEpisodes : availableEpisodes;
            AvailableEpisodesDetail availableEpisodesDetail2 = (i & 1024) != 0 ? edges.availableEpisodesDetail : availableEpisodesDetail;
            List list7 = (i & 2048) != 0 ? edges.studios : list;
            List list8 = (i & 4096) != 0 ? edges.genres : list2;
            Integer num4 = (i & 8192) != 0 ? edges.averageScore : num;
            String str16 = str10;
            List list9 = (i & 16384) != 0 ? edges.characters : list3;
            List list10 = (i & 32768) != 0 ? edges.altNames : list4;
            String str17 = (i & 65536) != 0 ? edges.description : str7;
            String str18 = (i & 131072) != 0 ? edges.status : str8;
            String str19 = (i & 262144) != 0 ? edges.banner : str9;
            Integer num5 = (i & 524288) != 0 ? edges.episodeDuration : num2;
            if ((i & 1048576) != 0) {
                num3 = num5;
                list6 = edges.prevideos;
            } else {
                list6 = list5;
                num3 = num5;
            }
            return edges.copy(str16, str11, str12, str13, str14, str15, season2, d2, airedStart2, availableEpisodes2, availableEpisodesDetail2, list7, list8, num4, list9, list10, str17, str18, str19, num3, list6);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.Id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final AvailableEpisodes getAvailableEpisodes() {
            return this.availableEpisodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final AvailableEpisodesDetail getAvailableEpisodesDetail() {
            return this.availableEpisodesDetail;
        }

        @Nullable
        public final List<String> component12() {
            return this.studios;
        }

        @Nullable
        public final List<String> component13() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @Nullable
        public final List<Characters> component15() {
            return this.characters;
        }

        @Nullable
        public final List<String> component16() {
            return this.altNames;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getBanner() {
            return this.banner;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Integer getEpisodeDuration() {
            return this.episodeDuration;
        }

        @NotNull
        public final List<String> component21() {
            return this.prevideos;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEnglishName() {
            return this.englishName;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNativeName() {
            return this.nativeName;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Season getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final AiredStart getAiredStart() {
            return this.airedStart;
        }

        @NotNull
        public final Edges copy(@JsonProperty("_id") @Nullable String Id, @JsonProperty("name") @Nullable String name, @JsonProperty("englishName") @Nullable String englishName, @JsonProperty("nativeName") @Nullable String nativeName, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Season season, @JsonProperty("score") @Nullable Double score, @JsonProperty("airedStart") @Nullable AiredStart airedStart, @JsonProperty("availableEpisodes") @Nullable AvailableEpisodes availableEpisodes, @JsonProperty("availableEpisodesDetail") @Nullable AvailableEpisodesDetail availableEpisodesDetail, @JsonProperty("studios") @Nullable List<String> studios, @JsonProperty("genres") @Nullable List<String> genres, @JsonProperty("averageScore") @Nullable Integer averageScore, @JsonProperty("characters") @Nullable List<Characters> characters, @JsonProperty("altNames") @Nullable List<String> altNames, @JsonProperty("description") @Nullable String description, @JsonProperty("status") @Nullable String status, @JsonProperty("banner") @Nullable String banner, @JsonProperty("episodeDuration") @Nullable Integer episodeDuration, @JsonProperty("prevideos") @NotNull List<String> prevideos) {
            return new Edges(Id, name, englishName, nativeName, thumbnail, type, season, score, airedStart, availableEpisodes, availableEpisodesDetail, studios, genres, averageScore, characters, altNames, description, status, banner, episodeDuration, prevideos);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edges)) {
                return false;
            }
            Edges edges = (Edges) other;
            return Intrinsics.areEqual(this.Id, edges.Id) && Intrinsics.areEqual(this.name, edges.name) && Intrinsics.areEqual(this.englishName, edges.englishName) && Intrinsics.areEqual(this.nativeName, edges.nativeName) && Intrinsics.areEqual(this.thumbnail, edges.thumbnail) && Intrinsics.areEqual(this.type, edges.type) && Intrinsics.areEqual(this.season, edges.season) && Intrinsics.areEqual(this.score, edges.score) && Intrinsics.areEqual(this.airedStart, edges.airedStart) && Intrinsics.areEqual(this.availableEpisodes, edges.availableEpisodes) && Intrinsics.areEqual(this.availableEpisodesDetail, edges.availableEpisodesDetail) && Intrinsics.areEqual(this.studios, edges.studios) && Intrinsics.areEqual(this.genres, edges.genres) && Intrinsics.areEqual(this.averageScore, edges.averageScore) && Intrinsics.areEqual(this.characters, edges.characters) && Intrinsics.areEqual(this.altNames, edges.altNames) && Intrinsics.areEqual(this.description, edges.description) && Intrinsics.areEqual(this.status, edges.status) && Intrinsics.areEqual(this.banner, edges.banner) && Intrinsics.areEqual(this.episodeDuration, edges.episodeDuration) && Intrinsics.areEqual(this.prevideos, edges.prevideos);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((this.Id == null ? 0 : this.Id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.englishName == null ? 0 : this.englishName.hashCode())) * 31) + (this.nativeName == null ? 0 : this.nativeName.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.score == null ? 0 : this.score.hashCode())) * 31) + (this.airedStart == null ? 0 : this.airedStart.hashCode())) * 31) + (this.availableEpisodes == null ? 0 : this.availableEpisodes.hashCode())) * 31) + (this.availableEpisodesDetail == null ? 0 : this.availableEpisodesDetail.hashCode())) * 31) + (this.studios == null ? 0 : this.studios.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.averageScore == null ? 0 : this.averageScore.hashCode())) * 31) + (this.characters == null ? 0 : this.characters.hashCode())) * 31) + (this.altNames == null ? 0 : this.altNames.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.banner == null ? 0 : this.banner.hashCode())) * 31) + (this.episodeDuration != null ? this.episodeDuration.hashCode() : 0)) * 31) + this.prevideos.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Edges(Id=").append(this.Id).append(", name=").append(this.name).append(", englishName=").append(this.englishName).append(", nativeName=").append(this.nativeName).append(", thumbnail=").append(this.thumbnail).append(", type=").append(this.type).append(", season=").append(this.season).append(", score=").append(this.score).append(", airedStart=").append(this.airedStart).append(", availableEpisodes=").append(this.availableEpisodes).append(", availableEpisodesDetail=").append(this.availableEpisodesDetail).append(", studios=");
            sb.append(this.studios).append(", genres=").append(this.genres).append(", averageScore=").append(this.averageScore).append(", characters=").append(this.characters).append(", altNames=").append(this.altNames).append(", description=").append(this.description).append(", status=").append(this.status).append(", banner=").append(this.banner).append(", episodeDuration=").append(this.episodeDuration).append(", prevideos=").append(this.prevideos).append(')');
            return sb.toString();
        }

        public Edges(@JsonProperty("_id") @Nullable String Id, @JsonProperty("name") @Nullable String name, @JsonProperty("englishName") @Nullable String englishName, @JsonProperty("nativeName") @Nullable String nativeName, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Season season, @JsonProperty("score") @Nullable Double score, @JsonProperty("airedStart") @Nullable AiredStart airedStart, @JsonProperty("availableEpisodes") @Nullable AvailableEpisodes availableEpisodes, @JsonProperty("availableEpisodesDetail") @Nullable AvailableEpisodesDetail availableEpisodesDetail, @JsonProperty("studios") @Nullable List<String> list, @JsonProperty("genres") @Nullable List<String> list2, @JsonProperty("averageScore") @Nullable Integer averageScore, @JsonProperty("characters") @Nullable List<Characters> list3, @JsonProperty("altNames") @Nullable List<String> list4, @JsonProperty("description") @Nullable String description, @JsonProperty("status") @Nullable String status, @JsonProperty("banner") @Nullable String banner, @JsonProperty("episodeDuration") @Nullable Integer episodeDuration, @JsonProperty("prevideos") @NotNull List<String> list5) {
            this.Id = Id;
            this.name = name;
            this.englishName = englishName;
            this.nativeName = nativeName;
            this.thumbnail = thumbnail;
            this.type = type;
            this.season = season;
            this.score = score;
            this.airedStart = airedStart;
            this.availableEpisodes = availableEpisodes;
            this.availableEpisodesDetail = availableEpisodesDetail;
            this.studios = list;
            this.genres = list2;
            this.averageScore = averageScore;
            this.characters = list3;
            this.altNames = list4;
            this.description = description;
            this.status = status;
            this.banner = banner;
            this.episodeDuration = episodeDuration;
            this.prevideos = list5;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Edges(String str, String str2, String str3, String str4, String str5, String str6, Season season, Double d, AiredStart airedStart, AvailableEpisodes availableEpisodes, AvailableEpisodesDetail availableEpisodesDetail, List list, List list2, Integer num, List list3, List list4, String str7, String str8, String str9, Integer num2, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            List listEmptyList;
            if ((i & 1048576) == 0) {
                listEmptyList = list5;
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            this(str, str2, str3, str4, str5, str6, season, d, airedStart, availableEpisodes, availableEpisodesDetail, list, list2, num, list3, list4, str7, str8, str9, num2, listEmptyList);
        }

        @Nullable
        public final String getId() {
            return this.Id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getEnglishName() {
            return this.englishName;
        }

        @Nullable
        public final String getNativeName() {
            return this.nativeName;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Season getSeason() {
            return this.season;
        }

        @Nullable
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        public final AiredStart getAiredStart() {
            return this.airedStart;
        }

        @Nullable
        public final AvailableEpisodes getAvailableEpisodes() {
            return this.availableEpisodes;
        }

        @Nullable
        public final AvailableEpisodesDetail getAvailableEpisodesDetail() {
            return this.availableEpisodesDetail;
        }

        @Nullable
        public final List<String> getStudios() {
            return this.studios;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @Nullable
        public final List<Characters> getCharacters() {
            return this.characters;
        }

        @Nullable
        public final List<String> getAltNames() {
            return this.altNames;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getBanner() {
            return this.banner;
        }

        @Nullable
        public final Integer getEpisodeDuration() {
            return this.episodeDuration;
        }

        @NotNull
        public final List<String> getPrevideos() {
            return this.prevideos;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003JQ\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/Anichi/AnichiParser$AvailableEpisodes;", "", "sub", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "dub", "raw", "<init>", "(III)V", "getSub", "()I", "getDub", "getRaw", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AvailableEpisodes {
        private final int dub;
        private final int raw;
        private final int sub;

        public static /* synthetic */ AvailableEpisodes copy$default(AvailableEpisodes availableEpisodes, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = availableEpisodes.sub;
            }
            if ((i4 & 2) != 0) {
                i2 = availableEpisodes.dub;
            }
            if ((i4 & 4) != 0) {
                i3 = availableEpisodes.raw;
            }
            return availableEpisodes.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSub() {
            return this.sub;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getDub() {
            return this.dub;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getRaw() {
            return this.raw;
        }

        @NotNull
        public final AvailableEpisodes copy(@JsonProperty("sub") int sub, @JsonProperty("dub") int dub, @JsonProperty("raw") int raw) {
            return new AvailableEpisodes(sub, dub, raw);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvailableEpisodes)) {
                return false;
            }
            AvailableEpisodes availableEpisodes = (AvailableEpisodes) other;
            return this.sub == availableEpisodes.sub && this.dub == availableEpisodes.dub && this.raw == availableEpisodes.raw;
        }

        public int hashCode() {
            return (((this.sub * 31) + this.dub) * 31) + this.raw;
        }

        @NotNull
        public String toString() {
            return "AvailableEpisodes(sub=" + this.sub + ", dub=" + this.dub + ", raw=" + this.raw + ')';
        }

        public AvailableEpisodes(@JsonProperty("sub") int sub, @JsonProperty("dub") int dub, @JsonProperty("raw") int raw) {
            this.sub = sub;
            this.dub = dub;
            this.raw = raw;
        }

        public final int getSub() {
            return this.sub;
        }

        public final int getDub() {
            return this.dub;
        }

        public final int getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003JQ\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/Anichi/AnichiParser$AiredStart;", "", "year", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "month", "date", "<init>", "(III)V", "getYear", "()I", "getMonth", "getDate", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AiredStart {
        private final int date;
        private final int month;
        private final int year;

        public static /* synthetic */ AiredStart copy$default(AiredStart airedStart, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = airedStart.year;
            }
            if ((i4 & 2) != 0) {
                i2 = airedStart.month;
            }
            if ((i4 & 4) != 0) {
                i3 = airedStart.date;
            }
            return airedStart.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getYear() {
            return this.year;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMonth() {
            return this.month;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getDate() {
            return this.date;
        }

        @NotNull
        public final AiredStart copy(@JsonProperty("year") int year, @JsonProperty("month") int month, @JsonProperty("date") int date) {
            return new AiredStart(year, month, date);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AiredStart)) {
                return false;
            }
            AiredStart airedStart = (AiredStart) other;
            return this.year == airedStart.year && this.month == airedStart.month && this.date == airedStart.date;
        }

        public int hashCode() {
            return (((this.year * 31) + this.month) * 31) + this.date;
        }

        @NotNull
        public String toString() {
            return "AiredStart(year=" + this.year + ", month=" + this.month + ", date=" + this.date + ')';
        }

        public AiredStart(@JsonProperty("year") int year, @JsonProperty("month") int month, @JsonProperty("date") int date) {
            this.year = year;
            this.month = month;
            this.date = date;
        }

        public final int getYear() {
            return this.year;
        }

        public final int getMonth() {
            return this.month;
        }

        public final int getDate() {
            return this.date;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/Anichi/AnichiParser$Season;", "", "quarter", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "year", "", "<init>", "(Ljava/lang/String;I)V", "getQuarter", "()Ljava/lang/String;", "getYear", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Season {

        @NotNull
        private final String quarter;
        private final int year;

        public static /* synthetic */ Season copy$default(Season season, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = season.quarter;
            }
            if ((i2 & 2) != 0) {
                i = season.year;
            }
            return season.copy(str, i);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getQuarter() {
            return this.quarter;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getYear() {
            return this.year;
        }

        @NotNull
        public final Season copy(@JsonProperty("quarter") @NotNull String quarter, @JsonProperty("year") int year) {
            return new Season(quarter, year);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Season)) {
                return false;
            }
            Season season = (Season) other;
            return Intrinsics.areEqual(this.quarter, season.quarter) && this.year == season.year;
        }

        public int hashCode() {
            return (this.quarter.hashCode() * 31) + this.year;
        }

        @NotNull
        public String toString() {
            return "Season(quarter=" + this.quarter + ", year=" + this.year + ')';
        }

        public Season(@JsonProperty("quarter") @NotNull String quarter, @JsonProperty("year") int year) {
            this.quarter = quarter;
            this.year = year;
        }

        @NotNull
        public final String getQuarter() {
            return this.quarter;
        }

        public final int getYear() {
            return this.year;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$AnichiQuery;", "", "data", "Lcom/Anichi/AnichiParser$Data;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$Data;)V", "getData", "()Lcom/Anichi/AnichiParser$Data;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnichiQuery {

        @Nullable
        private final Data data;

        /* JADX WARN: Illegal instructions before constructor call */
        public AnichiQuery() {
            Data data = null;
            this(data, 1, data);
        }

        public static /* synthetic */ AnichiQuery copy$default(AnichiQuery anichiQuery, Data data, int i, Object obj) {
            if ((i & 1) != 0) {
                data = anichiQuery.data;
            }
            return anichiQuery.copy(data);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Data getData() {
            return this.data;
        }

        @NotNull
        public final AnichiQuery copy(@JsonProperty("data") @Nullable Data data) {
            return new AnichiQuery(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnichiQuery) && Intrinsics.areEqual(this.data, ((AnichiQuery) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnichiQuery(data=" + this.data + ')';
        }

        public AnichiQuery(@JsonProperty("data") @Nullable Data data) {
            this.data = data;
        }

        public /* synthetic */ AnichiQuery(Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : data);
        }

        @Nullable
        public final Data getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$Detail;", "", "data", "Lcom/Anichi/AnichiParser$DetailShow;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$DetailShow;)V", "getData", "()Lcom/Anichi/AnichiParser$DetailShow;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Detail {

        @NotNull
        private final DetailShow data;

        public static /* synthetic */ Detail copy$default(Detail detail, DetailShow detailShow, int i, Object obj) {
            if ((i & 1) != 0) {
                detailShow = detail.data;
            }
            return detail.copy(detailShow);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DetailShow getData() {
            return this.data;
        }

        @NotNull
        public final Detail copy(@JsonProperty("data") @NotNull DetailShow data) {
            return new Detail(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Detail) && Intrinsics.areEqual(this.data, ((Detail) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "Detail(data=" + this.data + ')';
        }

        public Detail(@JsonProperty("data") @NotNull DetailShow data) {
            this.data = data;
        }

        @NotNull
        public final DetailShow getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$DetailShow;", "", "show", "Lcom/Anichi/AnichiParser$Edges;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Anichi/AnichiParser$Edges;)V", "getShow", "()Lcom/Anichi/AnichiParser$Edges;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class DetailShow {

        @NotNull
        private final Edges show;

        public static /* synthetic */ DetailShow copy$default(DetailShow detailShow, Edges edges, int i, Object obj) {
            if ((i & 1) != 0) {
                edges = detailShow.show;
            }
            return detailShow.copy(edges);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Edges getShow() {
            return this.show;
        }

        @NotNull
        public final DetailShow copy(@JsonProperty("show") @NotNull Edges show) {
            return new DetailShow(show);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DetailShow) && Intrinsics.areEqual(this.show, ((DetailShow) other).show);
        }

        public int hashCode() {
            return this.show.hashCode();
        }

        @NotNull
        public String toString() {
            return "DetailShow(show=" + this.show + ')';
        }

        public DetailShow(@JsonProperty("show") @NotNull Edges show) {
            this.show = show;
        }

        @NotNull
        public final Edges getShow() {
            return this.show;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u001c\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u001c\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u001c\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003Jc\u0010\u0012\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00022\u001c\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u001c\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/Anichi/AnichiParser$AvailableEpisodesDetail;", "", "sub", "", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "dub", "raw", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSub", "()Ljava/util/List;", "getDub", "getRaw", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AvailableEpisodesDetail {

        @NotNull
        private final List<String> dub;

        @NotNull
        private final List<String> raw;

        @NotNull
        private final List<String> sub;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AvailableEpisodesDetail copy$default(AvailableEpisodesDetail availableEpisodesDetail, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = availableEpisodesDetail.sub;
            }
            if ((i & 2) != 0) {
                list2 = availableEpisodesDetail.dub;
            }
            if ((i & 4) != 0) {
                list3 = availableEpisodesDetail.raw;
            }
            return availableEpisodesDetail.copy(list, list2, list3);
        }

        @NotNull
        public final List<String> component1() {
            return this.sub;
        }

        @NotNull
        public final List<String> component2() {
            return this.dub;
        }

        @NotNull
        public final List<String> component3() {
            return this.raw;
        }

        @NotNull
        public final AvailableEpisodesDetail copy(@JsonProperty("sub") @NotNull List<String> sub, @JsonProperty("dub") @NotNull List<String> dub, @JsonProperty("raw") @NotNull List<String> raw) {
            return new AvailableEpisodesDetail(sub, dub, raw);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvailableEpisodesDetail)) {
                return false;
            }
            AvailableEpisodesDetail availableEpisodesDetail = (AvailableEpisodesDetail) other;
            return Intrinsics.areEqual(this.sub, availableEpisodesDetail.sub) && Intrinsics.areEqual(this.dub, availableEpisodesDetail.dub) && Intrinsics.areEqual(this.raw, availableEpisodesDetail.raw);
        }

        public int hashCode() {
            return (((this.sub.hashCode() * 31) + this.dub.hashCode()) * 31) + this.raw.hashCode();
        }

        @NotNull
        public String toString() {
            return "AvailableEpisodesDetail(sub=" + this.sub + ", dub=" + this.dub + ", raw=" + this.raw + ')';
        }

        public AvailableEpisodesDetail(@JsonProperty("sub") @NotNull List<String> list, @JsonProperty("dub") @NotNull List<String> list2, @JsonProperty("raw") @NotNull List<String> list3) {
            this.sub = list;
            this.dub = list2;
            this.raw = list3;
        }

        @NotNull
        public final List<String> getSub() {
            return this.sub;
        }

        @NotNull
        public final List<String> getDub() {
            return this.dub;
        }

        @NotNull
        public final List<String> getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/Anichi/AnichiParser$LinksQuery;", "", "data", "Lcom/Anichi/AnichiParser$LinkData;", "episode", "Lcom/Anichi/AnichiParser$Episode;", "<init>", "(Lcom/Anichi/AnichiParser$LinkData;Lcom/Anichi/AnichiParser$Episode;)V", "getData", "()Lcom/Anichi/AnichiParser$LinkData;", "getEpisode", "()Lcom/Anichi/AnichiParser$Episode;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinksQuery {

        @Nullable
        private final LinkData data;

        @Nullable
        private final Episode episode;

        /* JADX WARN: Multi-variable type inference failed */
        public LinksQuery() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ LinksQuery copy$default(LinksQuery linksQuery, LinkData linkData, Episode episode, int i, Object obj) {
            if ((i & 1) != 0) {
                linkData = linksQuery.data;
            }
            if ((i & 2) != 0) {
                episode = linksQuery.episode;
            }
            return linksQuery.copy(linkData, episode);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LinkData getData() {
            return this.data;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Episode getEpisode() {
            return this.episode;
        }

        @NotNull
        public final LinksQuery copy(@Nullable LinkData data, @Nullable Episode episode) {
            return new LinksQuery(data, episode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinksQuery)) {
                return false;
            }
            LinksQuery linksQuery = (LinksQuery) other;
            return Intrinsics.areEqual(this.data, linksQuery.data) && Intrinsics.areEqual(this.episode, linksQuery.episode);
        }

        public int hashCode() {
            return ((this.data == null ? 0 : this.data.hashCode()) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LinksQuery(data=" + this.data + ", episode=" + this.episode + ')';
        }

        public LinksQuery(@Nullable LinkData data, @Nullable Episode episode) {
            this.data = data;
            this.episode = episode;
        }

        public /* synthetic */ LinksQuery(LinkData linkData, Episode episode, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : linkData, (i & 2) != 0 ? null : episode);
        }

        @Nullable
        public final LinkData getData() {
            return this.data;
        }

        @Nullable
        public final Episode getEpisode() {
            return this.episode;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/Anichi/AnichiParser$LinkData;", "", "episode", "Lcom/Anichi/AnichiParser$Episode;", "<init>", "(Lcom/Anichi/AnichiParser$Episode;)V", "getEpisode", "()Lcom/Anichi/AnichiParser$Episode;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @Nullable
        private final Episode episode;

        /* JADX WARN: Illegal instructions before constructor call */
        public LinkData() {
            Episode episode = null;
            this(episode, 1, episode);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, Episode episode, int i, Object obj) {
            if ((i & 1) != 0) {
                episode = linkData.episode;
            }
            return linkData.copy(episode);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Episode getEpisode() {
            return this.episode;
        }

        @NotNull
        public final LinkData copy(@Nullable Episode episode) {
            return new LinkData(episode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LinkData) && Intrinsics.areEqual(this.episode, ((LinkData) other).episode);
        }

        public int hashCode() {
            if (this.episode == null) {
                return 0;
            }
            return this.episode.hashCode();
        }

        @NotNull
        public String toString() {
            return "LinkData(episode=" + this.episode + ')';
        }

        public LinkData(@Nullable Episode episode) {
            this.episode = episode;
        }

        public /* synthetic */ LinkData(Episode episode, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : episode);
        }

        @Nullable
        public final Episode getEpisode() {
            return this.episode;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$Episode;", "", "sourceUrls", "Ljava/util/ArrayList;", "Lcom/Anichi/AnichiParser$SourceUrls;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getSourceUrls", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Episode {

        @NotNull
        private final ArrayList<SourceUrls> sourceUrls;

        /* JADX WARN: Illegal instructions before constructor call */
        public Episode() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Episode copy$default(Episode episode, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = episode.sourceUrls;
            }
            return episode.copy(arrayList);
        }

        @NotNull
        public final ArrayList<SourceUrls> component1() {
            return this.sourceUrls;
        }

        @NotNull
        public final Episode copy(@NotNull ArrayList<SourceUrls> sourceUrls) {
            return new Episode(sourceUrls);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Episode) && Intrinsics.areEqual(this.sourceUrls, ((Episode) other).sourceUrls);
        }

        public int hashCode() {
            return this.sourceUrls.hashCode();
        }

        @NotNull
        public String toString() {
            return "Episode(sourceUrls=" + this.sourceUrls + ')';
        }

        public Episode(@NotNull ArrayList<SourceUrls> arrayList) {
            this.sourceUrls = arrayList;
        }

        public /* synthetic */ Episode(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @NotNull
        public final ArrayList<SourceUrls> getSourceUrls() {
            return this.sourceUrls;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, d2 = {"Lcom/Anichi/AnichiParser$SourceUrls;", "", "sourceUrl", "", "downloads", "Lcom/Anichi/AnichiParser$Downloads;", "priority", "", "sourceName", "type", "className", "streamerId", "<init>", "(Ljava/lang/String;Lcom/Anichi/AnichiParser$Downloads;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSourceUrl", "()Ljava/lang/String;", "getDownloads", "()Lcom/Anichi/AnichiParser$Downloads;", "getPriority", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSourceName", "getType", "getClassName", "getStreamerId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/Anichi/AnichiParser$Downloads;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/Anichi/AnichiParser$SourceUrls;", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SourceUrls {

        @Nullable
        private final String className;

        @Nullable
        private final Downloads downloads;

        @Nullable
        private final Double priority;

        @Nullable
        private final String sourceName;

        @Nullable
        private final String sourceUrl;

        @Nullable
        private final String streamerId;

        @Nullable
        private final String type;

        public SourceUrls() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ SourceUrls copy$default(SourceUrls sourceUrls, String str, Downloads downloads, Double d, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sourceUrls.sourceUrl;
            }
            if ((i & 2) != 0) {
                downloads = sourceUrls.downloads;
            }
            if ((i & 4) != 0) {
                d = sourceUrls.priority;
            }
            if ((i & 8) != 0) {
                str2 = sourceUrls.sourceName;
            }
            if ((i & 16) != 0) {
                str3 = sourceUrls.type;
            }
            if ((i & 32) != 0) {
                str4 = sourceUrls.className;
            }
            if ((i & 64) != 0) {
                str5 = sourceUrls.streamerId;
            }
            String str6 = str4;
            String str7 = str5;
            String str8 = str3;
            Double d2 = d;
            return sourceUrls.copy(str, downloads, d2, str2, str8, str6, str7);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSourceUrl() {
            return this.sourceUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Downloads getDownloads() {
            return this.downloads;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Double getPriority() {
            return this.priority;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSourceName() {
            return this.sourceName;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getClassName() {
            return this.className;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getStreamerId() {
            return this.streamerId;
        }

        @NotNull
        public final SourceUrls copy(@Nullable String sourceUrl, @Nullable Downloads downloads, @Nullable Double priority, @Nullable String sourceName, @Nullable String type, @Nullable String className, @Nullable String streamerId) {
            return new SourceUrls(sourceUrl, downloads, priority, sourceName, type, className, streamerId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SourceUrls)) {
                return false;
            }
            SourceUrls sourceUrls = (SourceUrls) other;
            return Intrinsics.areEqual(this.sourceUrl, sourceUrls.sourceUrl) && Intrinsics.areEqual(this.downloads, sourceUrls.downloads) && Intrinsics.areEqual(this.priority, sourceUrls.priority) && Intrinsics.areEqual(this.sourceName, sourceUrls.sourceName) && Intrinsics.areEqual(this.type, sourceUrls.type) && Intrinsics.areEqual(this.className, sourceUrls.className) && Intrinsics.areEqual(this.streamerId, sourceUrls.streamerId);
        }

        public int hashCode() {
            return ((((((((((((this.sourceUrl == null ? 0 : this.sourceUrl.hashCode()) * 31) + (this.downloads == null ? 0 : this.downloads.hashCode())) * 31) + (this.priority == null ? 0 : this.priority.hashCode())) * 31) + (this.sourceName == null ? 0 : this.sourceName.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.className == null ? 0 : this.className.hashCode())) * 31) + (this.streamerId != null ? this.streamerId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SourceUrls(sourceUrl=" + this.sourceUrl + ", downloads=" + this.downloads + ", priority=" + this.priority + ", sourceName=" + this.sourceName + ", type=" + this.type + ", className=" + this.className + ", streamerId=" + this.streamerId + ')';
        }

        public SourceUrls(@Nullable String sourceUrl, @Nullable Downloads downloads, @Nullable Double priority, @Nullable String sourceName, @Nullable String type, @Nullable String className, @Nullable String streamerId) {
            this.sourceUrl = sourceUrl;
            this.downloads = downloads;
            this.priority = priority;
            this.sourceName = sourceName;
            this.type = type;
            this.className = className;
            this.streamerId = streamerId;
        }

        public /* synthetic */ SourceUrls(String str, Downloads downloads, Double d, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : downloads, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
        }

        @Nullable
        public final String getSourceUrl() {
            return this.sourceUrl;
        }

        @Nullable
        public final Downloads getDownloads() {
            return this.downloads;
        }

        @Nullable
        public final Double getPriority() {
            return this.priority;
        }

        @Nullable
        public final String getSourceName() {
            return this.sourceName;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getClassName() {
            return this.className;
        }

        @Nullable
        public final String getStreamerId() {
            return this.streamerId;
        }
    }

    /* JADX INFO: compiled from: AnichiParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/Anichi/AnichiParser$Downloads;", "", "sourceName", "", "downloadUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "getDownloadUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Downloads {

        @Nullable
        private final String downloadUrl;

        @Nullable
        private final String sourceName;

        /* JADX WARN: Illegal instructions before constructor call */
        public Downloads() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ Downloads copy$default(Downloads downloads, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloads.sourceName;
            }
            if ((i & 2) != 0) {
                str2 = downloads.downloadUrl;
            }
            return downloads.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSourceName() {
            return this.sourceName;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDownloadUrl() {
            return this.downloadUrl;
        }

        @NotNull
        public final Downloads copy(@Nullable String sourceName, @Nullable String downloadUrl) {
            return new Downloads(sourceName, downloadUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Downloads)) {
                return false;
            }
            Downloads downloads = (Downloads) other;
            return Intrinsics.areEqual(this.sourceName, downloads.sourceName) && Intrinsics.areEqual(this.downloadUrl, downloads.downloadUrl);
        }

        public int hashCode() {
            return ((this.sourceName == null ? 0 : this.sourceName.hashCode()) * 31) + (this.downloadUrl != null ? this.downloadUrl.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Downloads(sourceName=" + this.sourceName + ", downloadUrl=" + this.downloadUrl + ')';
        }

        public Downloads(@Nullable String sourceName, @Nullable String downloadUrl) {
            this.sourceName = sourceName;
            this.downloadUrl = downloadUrl;
        }

        public /* synthetic */ Downloads(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getSourceName() {
            return this.sourceName;
        }

        @Nullable
        public final String getDownloadUrl() {
            return this.downloadUrl;
        }
    }
}
