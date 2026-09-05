package com.PublicSportsIPTV;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/PublicSportsIPTV/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0016\b\u0001\u0010\u0011\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J¥\u0001\u0010,\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0003\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u000f\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0016\b\u0003\u0010\u0011\u001a\u00020\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0001J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/PublicSportsIPTV/Root;", "", "author", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Author", "name", "lastUpdated", "last_updated", "headers", "Lcom/PublicSportsIPTV/Headers;", "totalMatches", "", "total_matches", "liveMatches", "live_matches", "upcomingMatches", "upcoming_matches", "matches", "", "Lcom/PublicSportsIPTV/Match;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/PublicSportsIPTV/Headers;JJJLjava/util/List;)V", "getAuthor", "()Ljava/lang/String;", "getName", "getLastUpdated", "getHeaders", "()Lcom/PublicSportsIPTV/Headers;", "getTotalMatches", "()J", "getLiveMatches", "getUpcomingMatches", "getMatches", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Root {

    @NotNull
    private final String author;

    @NotNull
    private final Headers headers;

    @NotNull
    private final String lastUpdated;
    private final long liveMatches;

    @NotNull
    private final List<Match> matches;

    @NotNull
    private final String name;
    private final long totalMatches;
    private final long upcomingMatches;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Root copy$default(Root root, String str, String str2, String str3, Headers headers, long j, long j2, long j3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = root.author;
        }
        if ((i & 2) != 0) {
            str2 = root.name;
        }
        if ((i & 4) != 0) {
            str3 = root.lastUpdated;
        }
        if ((i & 8) != 0) {
            headers = root.headers;
        }
        if ((i & 16) != 0) {
            j = root.totalMatches;
        }
        if ((i & 32) != 0) {
            j2 = root.liveMatches;
        }
        if ((i & 64) != 0) {
            j3 = root.upcomingMatches;
        }
        if ((i & 128) != 0) {
            list = root.matches;
        }
        List list2 = list;
        long j4 = j3;
        long j5 = j2;
        long j6 = j;
        return root.copy(str, str2, str3, headers, j6, j5, j4, list2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLastUpdated() {
        return this.lastUpdated;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTotalMatches() {
        return this.totalMatches;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getLiveMatches() {
        return this.liveMatches;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getUpcomingMatches() {
        return this.upcomingMatches;
    }

    @NotNull
    public final List<Match> component8() {
        return this.matches;
    }

    @NotNull
    public final Root copy(@JsonProperty("Author") @NotNull String author, @NotNull String name, @JsonProperty("last_updated") @NotNull String lastUpdated, @NotNull Headers headers, @JsonProperty("total_matches") long totalMatches, @JsonProperty("live_matches") long liveMatches, @JsonProperty("upcoming_matches") long upcomingMatches, @NotNull List<Match> matches) {
        return new Root(author, name, lastUpdated, headers, totalMatches, liveMatches, upcomingMatches, matches);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Root)) {
            return false;
        }
        Root root = (Root) other;
        return Intrinsics.areEqual(this.author, root.author) && Intrinsics.areEqual(this.name, root.name) && Intrinsics.areEqual(this.lastUpdated, root.lastUpdated) && Intrinsics.areEqual(this.headers, root.headers) && this.totalMatches == root.totalMatches && this.liveMatches == root.liveMatches && this.upcomingMatches == root.upcomingMatches && Intrinsics.areEqual(this.matches, root.matches);
    }

    public int hashCode() {
        return (((((((((((((this.author.hashCode() * 31) + this.name.hashCode()) * 31) + this.lastUpdated.hashCode()) * 31) + this.headers.hashCode()) * 31) + Root$$ExternalSyntheticBackport0.m3m(this.totalMatches)) * 31) + Root$$ExternalSyntheticBackport0.m3m(this.liveMatches)) * 31) + Root$$ExternalSyntheticBackport0.m3m(this.upcomingMatches)) * 31) + this.matches.hashCode();
    }

    @NotNull
    public String toString() {
        return "Root(author=" + this.author + ", name=" + this.name + ", lastUpdated=" + this.lastUpdated + ", headers=" + this.headers + ", totalMatches=" + this.totalMatches + ", liveMatches=" + this.liveMatches + ", upcomingMatches=" + this.upcomingMatches + ", matches=" + this.matches + ')';
    }

    public Root(@JsonProperty("Author") @NotNull String author, @NotNull String name, @JsonProperty("last_updated") @NotNull String lastUpdated, @NotNull Headers headers, @JsonProperty("total_matches") long totalMatches, @JsonProperty("live_matches") long liveMatches, @JsonProperty("upcoming_matches") long upcomingMatches, @NotNull List<Match> list) {
        this.author = author;
        this.name = name;
        this.lastUpdated = lastUpdated;
        this.headers = headers;
        this.totalMatches = totalMatches;
        this.liveMatches = liveMatches;
        this.upcomingMatches = upcomingMatches;
        this.matches = list;
    }

    @NotNull
    public final String getAuthor() {
        return this.author;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getLastUpdated() {
        return this.lastUpdated;
    }

    @NotNull
    public final Headers getHeaders() {
        return this.headers;
    }

    public final long getTotalMatches() {
        return this.totalMatches;
    }

    public final long getLiveMatches() {
        return this.liveMatches;
    }

    public final long getUpcomingMatches() {
        return this.upcomingMatches;
    }

    @NotNull
    public final List<Match> getMatches() {
        return this.matches;
    }
}
