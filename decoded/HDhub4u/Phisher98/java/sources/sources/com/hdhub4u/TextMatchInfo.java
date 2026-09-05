package com.hdhub4u;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDhub4u/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0016\b\u0001\u0010\n\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0016\b\u0001\u0010\u0011\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J£\u0001\u0010%\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0016\b\u0003\u0010\n\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0016\b\u0003\u0010\u000f\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0016\b\u0003\u0010\u0011\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012HÆ\u0001J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u0006,"}, d2 = {"Lcom/hdhub4u/TextMatchInfo;", "", "bestFieldScore", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "best_field_score", "bestFieldWeight", "", "best_field_weight", "fieldsMatched", "fields_matched", "numTokensDropped", "num_tokens_dropped", "score", "tokensMatched", "tokens_matched", "typoPrefixScore", "typo_prefix_score", "<init>", "(Ljava/lang/String;JJJLjava/lang/String;JJ)V", "getBestFieldScore", "()Ljava/lang/String;", "getBestFieldWeight", "()J", "getFieldsMatched", "getNumTokensDropped", "getScore", "getTokensMatched", "getTypoPrefixScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TextMatchInfo {

    @NotNull
    private final String bestFieldScore;
    private final long bestFieldWeight;
    private final long fieldsMatched;
    private final long numTokensDropped;

    @NotNull
    private final String score;
    private final long tokensMatched;
    private final long typoPrefixScore;

    public static /* synthetic */ TextMatchInfo copy$default(TextMatchInfo textMatchInfo, String str, long j, long j2, long j3, String str2, long j4, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textMatchInfo.bestFieldScore;
        }
        if ((i & 2) != 0) {
            j = textMatchInfo.bestFieldWeight;
        }
        if ((i & 4) != 0) {
            j2 = textMatchInfo.fieldsMatched;
        }
        if ((i & 8) != 0) {
            j3 = textMatchInfo.numTokensDropped;
        }
        if ((i & 16) != 0) {
            str2 = textMatchInfo.score;
        }
        if ((i & 32) != 0) {
            j4 = textMatchInfo.tokensMatched;
        }
        if ((i & 64) != 0) {
            j5 = textMatchInfo.typoPrefixScore;
        }
        String str3 = str2;
        long j6 = j3;
        long j7 = j2;
        return textMatchInfo.copy(str, j, j7, j6, str3, j4, j5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBestFieldScore() {
        return this.bestFieldScore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getBestFieldWeight() {
        return this.bestFieldWeight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getFieldsMatched() {
        return this.fieldsMatched;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getNumTokensDropped() {
        return this.numTokensDropped;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getTokensMatched() {
        return this.tokensMatched;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getTypoPrefixScore() {
        return this.typoPrefixScore;
    }

    @NotNull
    public final TextMatchInfo copy(@JsonProperty("best_field_score") @NotNull String bestFieldScore, @JsonProperty("best_field_weight") long bestFieldWeight, @JsonProperty("fields_matched") long fieldsMatched, @JsonProperty("num_tokens_dropped") long numTokensDropped, @NotNull String score, @JsonProperty("tokens_matched") long tokensMatched, @JsonProperty("typo_prefix_score") long typoPrefixScore) {
        return new TextMatchInfo(bestFieldScore, bestFieldWeight, fieldsMatched, numTokensDropped, score, tokensMatched, typoPrefixScore);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextMatchInfo)) {
            return false;
        }
        TextMatchInfo textMatchInfo = (TextMatchInfo) other;
        return Intrinsics.areEqual(this.bestFieldScore, textMatchInfo.bestFieldScore) && this.bestFieldWeight == textMatchInfo.bestFieldWeight && this.fieldsMatched == textMatchInfo.fieldsMatched && this.numTokensDropped == textMatchInfo.numTokensDropped && Intrinsics.areEqual(this.score, textMatchInfo.score) && this.tokensMatched == textMatchInfo.tokensMatched && this.typoPrefixScore == textMatchInfo.typoPrefixScore;
    }

    public int hashCode() {
        return (((((((((((this.bestFieldScore.hashCode() * 31) + TextMatchInfo$$ExternalSyntheticBackport0.m5m(this.bestFieldWeight)) * 31) + TextMatchInfo$$ExternalSyntheticBackport0.m5m(this.fieldsMatched)) * 31) + TextMatchInfo$$ExternalSyntheticBackport0.m5m(this.numTokensDropped)) * 31) + this.score.hashCode()) * 31) + TextMatchInfo$$ExternalSyntheticBackport0.m5m(this.tokensMatched)) * 31) + TextMatchInfo$$ExternalSyntheticBackport0.m5m(this.typoPrefixScore);
    }

    @NotNull
    public String toString() {
        return "TextMatchInfo(bestFieldScore=" + this.bestFieldScore + ", bestFieldWeight=" + this.bestFieldWeight + ", fieldsMatched=" + this.fieldsMatched + ", numTokensDropped=" + this.numTokensDropped + ", score=" + this.score + ", tokensMatched=" + this.tokensMatched + ", typoPrefixScore=" + this.typoPrefixScore + ')';
    }

    public TextMatchInfo(@JsonProperty("best_field_score") @NotNull String bestFieldScore, @JsonProperty("best_field_weight") long bestFieldWeight, @JsonProperty("fields_matched") long fieldsMatched, @JsonProperty("num_tokens_dropped") long numTokensDropped, @NotNull String score, @JsonProperty("tokens_matched") long tokensMatched, @JsonProperty("typo_prefix_score") long typoPrefixScore) {
        this.bestFieldScore = bestFieldScore;
        this.bestFieldWeight = bestFieldWeight;
        this.fieldsMatched = fieldsMatched;
        this.numTokensDropped = numTokensDropped;
        this.score = score;
        this.tokensMatched = tokensMatched;
        this.typoPrefixScore = typoPrefixScore;
    }

    @NotNull
    public final String getBestFieldScore() {
        return this.bestFieldScore;
    }

    public final long getBestFieldWeight() {
        return this.bestFieldWeight;
    }

    public final long getFieldsMatched() {
        return this.fieldsMatched;
    }

    public final long getNumTokensDropped() {
        return this.numTokensDropped;
    }

    @NotNull
    public final String getScore() {
        return this.score;
    }

    public final long getTokensMatched() {
        return this.tokensMatched;
    }

    public final long getTypoPrefixScore() {
        return this.typoPrefixScore;
    }
}
